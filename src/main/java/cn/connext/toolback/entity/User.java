package cn.connext.toolback.entity;

/**
 *  用户类，对应user表
 */
public class User {
    private int id;
    //身份证号
    private String idcardNo;
    //年龄
    private int age;
    //姓名
    private String name;
    //警号
    private long policeNo;
    //手机号
    private String phoneNumber;
    //用户类别  1 领导 2事故民警 3铁骑民警 4外围民警 5其他民警 6 铁骑辅警 7 重骑辅警 8 外围辅警 9 其他辅警
    private Integer userCategory;
    private String userCategoryName;
    //在职状态  1 在职 2离职 3调离
    private int serviceStatus;
    //值班组别 A B C D
    private Character dutyCategory;

    public String getUserCategoryName() {
        return userCategoryName;
    }

    public void setUserCategoryName(String userCategoryName) {
        this.userCategoryName = userCategoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPoliceNo() {
        return policeNo;
    }

    public void setPoliceNo(long policeNo) {
        this.policeNo = policeNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public Character getDutyCategory() {
        return dutyCategory;
    }

    public void setDutyCategory(Character dutyCategory) {
        this.dutyCategory = dutyCategory;
    }
}
