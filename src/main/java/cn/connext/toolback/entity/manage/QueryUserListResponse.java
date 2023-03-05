package cn.connext.toolback.entity.manage;

import cn.connext.toolback.entity.User;

import java.util.List;

/**
 *  查询用户列表
 */
public class QueryUserListResponse {
    private List<User> userList;
    private int totalCount;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
