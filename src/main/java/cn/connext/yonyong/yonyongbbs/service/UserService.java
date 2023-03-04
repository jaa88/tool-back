package cn.connext.yonyong.yonyongbbs.service;

import cn.connext.yonyong.yonyongbbs.entity.User;
import cn.connext.yonyong.yonyongbbs.entity.manage.QueryUserListParam;
import org.apache.ibatis.annotations.Param;

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
