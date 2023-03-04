package cn.connext.yonyong.yonyongbbs.dao;

import cn.connext.yonyong.yonyongbbs.entity.User;
import cn.connext.yonyong.yonyongbbs.entity.manage.QueryUserListParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 *
 */
@Repository
public interface UserDao {
    //查询所有符合条件数量
    Integer selectAllUserCount(QueryUserListParam queryUserListParam);
    //查询所有符合条件的数据
    List<User> selectUserListByParam(QueryUserListParam queryUserListParam);
}
