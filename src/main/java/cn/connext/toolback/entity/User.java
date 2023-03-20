package cn.connext.toolback.entity;

import java.math.BigInteger;

/**
 *  用户类，对应user表
 */
public class User {
    private Long id;
    //姓名
    private String name;
    //警号
    private String policeNo;
    //手机号
    private String phoneNumber;
    //用户类别  101 领导 102事故民警 103铁骑民警 104外围民警 105其他民警 201 铁骑辅警 202重骑辅警 203外围辅警 204机动 205城警 206事故 207勤务 208源头 209法制 210内勤 211窗口 212农副 213其他
    private Integer userCategory;
    private String userCategoryName;
    //在职状态  1 在职 2离职 3调离
    private int serviceStatus;
    //值班组别 A B C D    Z不参与
    private String dutyCategory;
    private String dutyCategoryName;
    //值班区域 1 城厢 2高新区
    private Integer dutyArea;
    private String dutyAreaName;
    //排序用
    private Integer orderNum;

    private Integer deleteFlag;

    public String getDutyAreaName() {
        return dutyAreaName;
    }

    public void setDutyAreaName(String dutyAreaName) {
        this.dutyAreaName = dutyAreaName;
    }

    public Integer getDutyArea() {
        return dutyArea;
    }

    public void setDutyArea(Integer dutyArea) {
        this.dutyArea = dutyArea;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getDutyCategoryName() {
        return dutyCategoryName;
    }

    public void setDutyCategoryName(String dutyCategoryName) {
        this.dutyCategoryName = dutyCategoryName;
    }

    public String getUserCategoryName() {
        return userCategoryName;
    }

    public void setUserCategoryName(String userCategoryName) {
        this.userCategoryName = userCategoryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPoliceNo() {
        return policeNo;
    }

    public void setPoliceNo(String policeNo) {
        this.policeNo = policeNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(Integer userCategory) {
        this.userCategory = userCategory;
    }

    public int getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(int serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public String getDutyCategory() {
        return dutyCategory;
    }

    public void setDutyCategory(String dutyCategory) {
        this.dutyCategory = dutyCategory;
    }
}
