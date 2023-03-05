package cn.connext.toolback.controller;

import cn.connext.toolback.entity.User;
import cn.connext.toolback.entity.manage.QueryUserListParam;
import cn.connext.toolback.entity.manage.QueryUserListResponse;
import cn.connext.toolback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@Controller
public class UserController {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    UserService userService;

    //查询用户列表
    @RequestMapping("/queryUserList")
    @ResponseBody
    public QueryUserListResponse queryUserList(@RequestBody QueryUserListParam queryUserListParam, HttpServletRequest request){
        QueryUserListResponse response=new QueryUserListResponse();
        int totalCount=userService.selectAllUserCount(queryUserListParam);
        response.setTotalCount(totalCount);
        if(totalCount>0){
            List<User> list=userService.selectUserListByParam(queryUserListParam);
            response.setUserList(list);
        }
        return response;
    }

}
