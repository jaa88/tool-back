package cn.connext.toolback.service;

import cn.connext.toolback.entity.Food;
import cn.connext.toolback.entity.User;
import cn.connext.toolback.entity.manage.QueryUserListParam;

import java.util.List;

public interface FoodService {

    List<Food> selectAllFood();

    int selectAllCount();
}
