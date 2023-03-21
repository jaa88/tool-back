package cn.connext.toolback.entity.manage;

import cn.connext.toolback.entity.User;

import java.math.BigInteger;
import java.util.Date;
import java.util.Map;

/**
 *  用户类，对应user表
 */
public class ArrangeClass {
    private Long id;
    private String curDutyCategory;//当天值班班组 A B C D
    private String curDayZeroTime;//当天值班日期的零点
    private String chengxiangDayTimePolice;//代表值班的民警id集合直接id拼接，逗号分割
    private String gaoxinDayTimePolice;
    private String chengxiangNightTimePolice;
    private String gaoxinNightTimePolice;
    private String chengxiangDayTimeRule;//排班规则 有几个小集合就是怎么轮流的。【（1,2,3）（2,3,1）（3,1,2）】代表所有人轮流；【（1,2,3）（1,3,2）】代表某个人固定1号位，另外两个人轮流
    private String chengxiangNightTimeRule;//同上
    private String gaoxinDayTimeRule;//同上
    private String gaoxinNightTimeRule;//同上
    private Map<Long, User> userMap;

    public Map<Long, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<Long, User> userMap) {
        this.userMap = userMap;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurDutyCategory() {
        return curDutyCategory;
    }

    public void setCurDutyCategory(String curDutyCategory) {
        this.curDutyCategory = curDutyCategory;
    }

    public String getCurDayZeroTime() {
        return curDayZeroTime;
    }

    public void setCurDayZeroTime(String curDayZeroTime) {
        this.curDayZeroTime = curDayZeroTime;
    }

    public String getChengxiangDayTimePolice() {
        return chengxiangDayTimePolice;
    }

    public void setChengxiangDayTimePolice(String chengxiangDayTimePolice) {
        this.chengxiangDayTimePolice = chengxiangDayTimePolice;
    }

    public String getGaoxinDayTimePolice() {
        return gaoxinDayTimePolice;
    }

    public void setGaoxinDayTimePolice(String gaoxinDayTimePolice) {
        this.gaoxinDayTimePolice = gaoxinDayTimePolice;
    }

    public String getChengxiangNightTimePolice() {
        return chengxiangNightTimePolice;
    }

    public void setChengxiangNightTimePolice(String chengxiangNightTimePolice) {
        this.chengxiangNightTimePolice = chengxiangNightTimePolice;
    }

    public String getGaoxinNightTimePolice() {
        return gaoxinNightTimePolice;
    }

    public void setGaoxinNightTimePolice(String gaoxinNightTimePolice) {
        this.gaoxinNightTimePolice = gaoxinNightTimePolice;
    }

    public String getChengxiangDayTimeRule() {
        return chengxiangDayTimeRule;
    }

    public void setChengxiangDayTimeRule(String chengxiangDayTimeRule) {
        this.chengxiangDayTimeRule = chengxiangDayTimeRule;
    }

    public String getChengxiangNightTimeRule() {
        return chengxiangNightTimeRule;
    }

    public void setChengxiangNightTimeRule(String chengxiangNightTimeRule) {
        this.chengxiangNightTimeRule = chengxiangNightTimeRule;
    }

    public String getGaoxinDayTimeRule() {
        return gaoxinDayTimeRule;
    }

    public void setGaoxinDayTimeRule(String gaoxinDayTimeRule) {
        this.gaoxinDayTimeRule = gaoxinDayTimeRule;
    }

    public String getGaoxinNightTimeRule() {
        return gaoxinNightTimeRule;
    }

    public void setGaoxinNightTimeRule(String gaoxinNightTimeRule) {
        this.gaoxinNightTimeRule = gaoxinNightTimeRule;
    }
}
