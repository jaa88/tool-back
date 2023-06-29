package cn.connext.toolback.controller;

import cn.connext.toolback.entity.Food;
import cn.connext.toolback.entity.ResultResponse;
import cn.connext.toolback.entity.User;
import cn.connext.toolback.entity.manage.QueryUserListParam;
import cn.connext.toolback.entity.manage.QueryUserListResponse;
import cn.connext.toolback.service.FoodService;
import cn.connext.toolback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@Controller
public class FoodController {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    FoodService foodService;

    @RequestMapping("/queryAllFood")
    @ResponseBody
    public String queryAllFood(HttpServletRequest request){
        List<Food> list=foodService.selectAllFood();

        int total=foodService.selectAllCount();

        System.out.println(total);
        System.out.println(list.size());
        return list.toString();
    }
}
