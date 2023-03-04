package cn.connext.yonyong.yonyongbbs.service.impl;

import cn.connext.yonyong.yonyongbbs.dao.UserDao;
import cn.connext.yonyong.yonyongbbs.entity.User;
import cn.connext.yonyong.yonyongbbs.entity.manage.QueryUserListParam;
import cn.connext.yonyong.yonyongbbs.service.UserService;
import cn.connext.yonyong.yonyongbbs.util.TransferNameUtil;
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
