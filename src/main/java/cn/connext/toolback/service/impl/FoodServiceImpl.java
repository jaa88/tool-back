package cn.connext.toolback.service.impl;

import cn.connext.toolback.dao.db1.UserDao;
import cn.connext.toolback.dao.db2.FoodDao;
import cn.connext.toolback.entity.Food;
import cn.connext.toolback.entity.User;
import cn.connext.toolback.entity.manage.QueryUserListParam;
import cn.connext.toolback.enums.UserCategoryEnum;
import cn.connext.toolback.service.FoodService;
import cn.connext.toolback.service.UserService;
import cn.connext.toolback.util.TransferNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodDao foodDao;


    @Override
    public List<Food> selectAllFood() {
        return foodDao.selectAllFood();
    }

    @Override
    public int selectAllCount() {
        return foodDao.selectAllCount();
    }
}
