package cn.connext.toolback.service.impl;

import cn.connext.toolback.dao.ArrangeClassDao;
import cn.connext.toolback.dao.UserDao;
import cn.connext.toolback.entity.User;
import cn.connext.toolback.entity.manage.ArrangeClass;
import cn.connext.toolback.entity.manage.QueryArrangeClassParam;
import cn.connext.toolback.entity.manage.QueryUserListParam;
import cn.connext.toolback.enums.UserCategoryEnum;
import cn.connext.toolback.service.ArrangeClassService;
import cn.connext.toolback.service.UserService;
import cn.connext.toolback.util.CommonUtil;
import cn.connext.toolback.util.TransferNameUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ArrangeClassServiceImpl implements ArrangeClassService {
    @Autowired
    ArrangeClassDao arrangeClassDao;
    @Autowired
    UserService userService;

    @Override
    public ArrangeClass selectTargetDateArrangeClass(String dateString) {
        ArrangeClass arrangeClass=arrangeClassDao.selectTargetDateArrangeClass(dateString);
        //取所有的用户id
        if(arrangeClass!=null){
            List<Long> userIdList=getUserIdListFromArrangeClass(arrangeClass);
            QueryUserListParam queryUserListParam=new QueryUserListParam();
            queryUserListParam.setIdList(userIdList);
            queryUserListParam.setPageNo(1);
            queryUserListParam.setPageSize(userIdList.size());
            List<User> userList=userService.selectUserListByParam(queryUserListParam);
            arrangeClass.setUserMap(converToUserMap(userList));
        }
        return arrangeClass;
    }

    /**
     * 逻辑：检查一下，当天的有没有，如果没有生成一条
     * 前一天的是什么，A B C D为一个循环，如果昨天是C班，那么今天是D班
     * 如果今天是D班，取上一个D班的，把rule里的【1，2，3】也循环一下
     */
    @Override
    public void checkAndInsertArrangeClass() {
        //取这个时间的当天0点，不考虑8：30的排班情况
        Date todayDate= new Date(CommonUtil.getDayZeroTimestamp(new Date()));
        ArrangeClass arrangeClass=arrangeClassDao.selectTargetDateArrangeClass(new SimpleDateFormat("yyyy-MM-dd").format(todayDate));
        if(arrangeClass==null){
            //查昨天的班次
            String yesterdayDateStr=new SimpleDateFormat("yyyy-MM-dd").format(new Date(todayDate.getTime()-3600*24*1000));
            ArrangeClass yesterdayArrangeClass=arrangeClassDao.selectTargetDateArrangeClass(yesterdayDateStr);
            if(yesterdayArrangeClass!=null){
                String todayDutyCategory=getTodayDutyCategory(yesterdayArrangeClass.getCurDutyCategory());
                if(todayDutyCategory!=null){
                    //获取到今天的值班组后，取最近的一次值班组信息
                    ArrangeClass lastDutyCategoryArrangeClass=arrangeClassDao.selectLastArrangeClassByDutyCategory(todayDutyCategory);
                    if(lastDutyCategoryArrangeClass!=null){
                        ArrangeClass newArrangeClass=generateNewArrangeClass(lastDutyCategoryArrangeClass);
                        arrangeClassDao.addArrangeClass(newArrangeClass);
                    }
                }
            }
        }else{
            System.out.println("今日已排班");
        }
    }

    private ArrangeClass generateNewArrangeClass(ArrangeClass oldArrangeClass){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ArrangeClass newArrangeClass= objectMapper.readValue(objectMapper.writeValueAsString(oldArrangeClass),ArrangeClass.class);
            newArrangeClass.setCurDayZeroTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date(CommonUtil.getDayZeroTimestamp(new Date()))));
            newArrangeClass.setChengxiangDayTimeRule(chengeRuleSequence(oldArrangeClass.getChengxiangDayTimeRule()));
            newArrangeClass.setChengxiangNightTimeRule(chengeRuleSequence(oldArrangeClass.getChengxiangNightTimeRule()));
            newArrangeClass.setGaoxinDayTimeRule(chengeRuleSequence(oldArrangeClass.getGaoxinDayTimeRule()));
            newArrangeClass.setGaoxinNightTimeRule(chengeRuleSequence(oldArrangeClass.getGaoxinNightTimeRule()));
            return newArrangeClass;
        } catch (IOException e) {
            e.printStackTrace();
            return oldArrangeClass;
        }
    }

    private String chengeRuleSequence(String rule){
        if(rule==null || rule.indexOf(';')<=-1){
            return rule;
        }
        String[] ruleSplitArr=rule.split(";");
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<ruleSplitArr.length;i++){
            sb.append(ruleSplitArr[i]);
            sb.append(";");
        }
        sb.append(ruleSplitArr[0]);
        return sb.toString();
    }

    //获取所有用户的id
    private List<Long> getUserIdListFromArrangeClass(ArrangeClass arrangeClass){
        String[] chengxiangDayTimePoliceStrArr=arrangeClass.getChengxiangDayTimePolice().split(",");
        String[] chengxiangNightTimePoliceStrArr=arrangeClass.getChengxiangNightTimePolice().split(",");
        String[] gaoxinDayTimePoliceStrArr=arrangeClass.getGaoxinDayTimePolice().split(",");
        String[] gaoxinNightTimePoliceStrArr=arrangeClass.getGaoxinNightTimePolice().split(",");
        Set<Long> idSet=new HashSet<>();
        for(String idStr:chengxiangDayTimePoliceStrArr){
            idSet.add(Long.parseLong(idStr));
        }
        for(String idStr:chengxiangNightTimePoliceStrArr){
            idSet.add(Long.parseLong(idStr));
        }
        for(String idStr:gaoxinDayTimePoliceStrArr){
            idSet.add(Long.parseLong(idStr));
        }
        for(String idStr:gaoxinNightTimePoliceStrArr){
            idSet.add(Long.parseLong(idStr));
        }
        return new ArrayList<>(idSet);
    }

    //获取所有用户的id
    private Map<Long ,User> converToUserMap(List<User> userList){
        Map<Long ,User> userMap=new HashMap<>();
        if(userList!=null && userList.size()>0){
            for(User user:userList){
                userMap.put(user.getId(),user);
            }
        }
        return userMap;
    }

    private String getTodayDutyCategory(String yesterdayDutyCategory){
        if("A".equals(yesterdayDutyCategory)){
            return "B";
        }else if("B".equals(yesterdayDutyCategory)){
            return "C";
        }else if("C".equals(yesterdayDutyCategory)){
            return "D";
        }else if("D".equals(yesterdayDutyCategory)){
            return "A";
        }
        return null;
    }
}
