package cn.connext.toolback.controller;

import cn.connext.toolback.entity.ResultResponse;
import cn.connext.toolback.entity.User;
import cn.connext.toolback.entity.manage.QueryUserListParam;
import cn.connext.toolback.entity.manage.QueryUserListResponse;
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
public class ArrangeClassController {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    UserService userService;

    //查询最新的排班信息
    @RequestMapping("/queryLatestClassInfo")
    @ResponseBody
    public ResultResponse queryLatestClassInfo(@RequestBody QueryUserListParam queryUserListParam, HttpServletRequest request){
        ResultResponse response=new ResultResponse();

        int totalCount=userService.selectAllUserCount(queryUserListParam);
        return response;
    }
}
