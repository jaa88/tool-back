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
import cn.connext.toolback.util.TransferNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArrangeClassServiceImpl implements ArrangeClassService {
    @Autowired
    ArrangeClassDao arrangeClassDao;
    @Autowired
    UserService userService;

    @Override
    public ArrangeClass selectTargetDateArrangeClass(Date date) {
        ArrangeClass arrangeClass=arrangeClassDao.selectTargetDateArrangeClass(date);
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
}
