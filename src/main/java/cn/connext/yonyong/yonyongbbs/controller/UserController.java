package cn.connext.yonyong.yonyongbbs.controller;

import cn.connext.yonyong.yonyongbbs.entity.Role;
import cn.connext.yonyong.yonyongbbs.entity.User;
import cn.connext.yonyong.yonyongbbs.entity.manage.QueryUserListParam;
import cn.connext.yonyong.yonyongbbs.entity.manage.QueryUserListResponse;
import cn.connext.yonyong.yonyongbbs.service.RoleService;
import cn.connext.yonyong.yonyongbbs.service.Role_perService;
import cn.connext.yonyong.yonyongbbs.service.UserService;
import cn.connext.yonyong.yonyongbbs.service.User_roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
