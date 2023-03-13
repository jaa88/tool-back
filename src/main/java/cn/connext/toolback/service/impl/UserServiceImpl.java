package cn.connext.toolback.service.impl;

import cn.connext.toolback.enums.UserCategoryEnum;
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
                user.setDutyCategoryName(TransferNameUtil.transferDutyCategoryName(user.getDutyCategory()));
                user.setDutyAreaName(TransferNameUtil.transferDutyAreaName(user.getDutyArea()));
            }
        }
        return userList;
    }

    @Override
    public Integer addUser(User user) {
        //如果是民警，非领导统一转成9999
        if(user.getUserCategory()==UserCategoryEnum.POLICE_MANAGER.getIndex()){
            //toto 这儿有问题，考虑领导排序，这个后期再说
            user.setOrderNum(100);
        }else if(user.getUserCategory()> UserCategoryEnum.POLICE_MANAGER.getIndex() && user.getUserCategory()<=UserCategoryEnum.POLICE_OTHER.getIndex()){
            user.setOrderNum(9999);
        }else {
            user.setOrderNum(19999);
        }
        return userDao.addUser(user);
    }

    @Override
    public Integer editUser(User user) {
        return userDao.editUser(user);
    }

    @Override
    public Integer deleteUserInfo(User user) {
        return userDao.deleteUser(user);
    }
}
