package cn.connext.toolback.dao.db1;

import cn.connext.toolback.entity.User;
import cn.connext.toolback.entity.manage.QueryUserListParam;
import org.springframework.stereotype.Repository;

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

    int addUser(User user);

    int editUser(User user);

    int deleteUser(User user);

    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAllUser();

    int selectAllCount();


}
