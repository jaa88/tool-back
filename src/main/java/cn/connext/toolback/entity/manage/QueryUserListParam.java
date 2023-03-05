package cn.connext.toolback.entity.manage;

/**
 *  查询用户列表
 */
public class QueryUserListParam {
    //姓名
    private String name;
    //警号
    private long policeNo;
    //是不是正式民警  1 民警 2 辅警
    private Integer formalOrNot;
    //在职状态  1 在职 2离职 3调离
    private int serviceStatus;
    //值班组别 A B C D      Z(不参与值班)
    private String dutyCategory;
    //用户类别
    private Integer userCategory;

    private int pageNo;
    private int pageSize;
    //起始 (pageNo-1)*pageSize
    private int startIndex;

    public Integer getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(Integer userCategory) {
        this.userCategory = userCategory;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPoliceNo() {
        return policeNo;
    }

    public void setPoliceNo(long policeNo) {
        this.policeNo = policeNo;
    }

    public Integer getFormalOrNot() {
        return formalOrNot;
    }

    public void setFormalOrNot(Integer formalOrNot) {
        this.formalOrNot = formalOrNot;
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

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
