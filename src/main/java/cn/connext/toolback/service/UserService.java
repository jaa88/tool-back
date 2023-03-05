package cn.connext.toolback.service;

import cn.connext.toolback.entity.User;
import cn.connext.toolback.entity.manage.QueryUserListParam;

import java.util.List;

public interface UserService {
    /**
     * 查询所有符合条件的用户数量
     * @return
     */
    Integer selectAllUserCount(QueryUserListParam param);
    /**
     * 查询所有符合条件的用户
     * @return
     */
    List<User> selectUserListByParam(QueryUserListParam param);
}
