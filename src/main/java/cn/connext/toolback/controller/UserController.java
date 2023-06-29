package cn.connext.toolback.controller;

import cn.connext.toolback.entity.ResultResponse;
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

    @RequestMapping("/queryAllUser")
    @ResponseBody
    public String queryUserList(HttpServletRequest request){
        List<User> list=userService.selectAllUser();

        int total=userService.selectAllCount();

        System.out.println(total);
        System.out.println(list.size());
        return list.toString();
    }


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

    //更新或者新增用户信息
    @RequestMapping("/editUserInfoOrAddUserInfo")
    @ResponseBody
    public ResultResponse editUserInfoOrAddUserInfo(@RequestBody User user, HttpServletRequest request){
        ResultResponse resultResponse=new ResultResponse();
        int count=user.getId()!=null?userService.editUser(user):userService.addUser(user);
       if(count==1){
           resultResponse.setSuccessFlag(true);
       }else{
           resultResponse.setSuccessFlag(false);
       }
        return resultResponse;
    }

    //删除用户信息
    @RequestMapping("/deleteUserInfo")
    @ResponseBody
    public ResultResponse deleteUserInfo(@RequestBody User user, HttpServletRequest request){
        ResultResponse resultResponse=new ResultResponse();
        int count=userService.deleteUserInfo(user);
        if(count==1){
            resultResponse.setSuccessFlag(true);
        }else{
            resultResponse.setSuccessFlag(false);
        }
        return resultResponse;
    }
}
