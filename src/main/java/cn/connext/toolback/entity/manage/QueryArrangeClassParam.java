package cn.connext.toolback.entity.manage;

import java.util.Date;

/**
 *  查询用户列表
 */
public class QueryArrangeClassParam {
    //对应天的排班
    private Date targetDate;

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }
}
