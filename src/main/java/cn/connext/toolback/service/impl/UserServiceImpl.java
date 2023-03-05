package cn.connext.toolback.service.impl;

import cn.connext.toolback.util.TransferNameUtil;
import cn.connext.toolback.dao.UserDao;
import cn.connext.toolback.entity.User;
import cn.connext.toolback.entity.manage.QueryUserListParam;
import cn.connext.toolback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public Integer selectAllUserCount(QueryUserListParam param) {
        return userDao.selectAllUserCount(param);
    }

    @Override
    public List<User> selectUserListByParam(QueryUserListParam param) {
        param.setStartIndex((param.getPageNo()-1)*param.getPageSize());
        List<User> userList=userDao.selectUserListByParam(param);
        if(!userList.isEmpty()){
            for(User user:userList){
                user.setUserCategoryName(TransferNameUtil.transferUserCategoryName(user.getUserCategory()));
            }
        }
        return userList;
    }
}
