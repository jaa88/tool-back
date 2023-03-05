package cn.connext.toolback.controller;

import cn.connext.toolback.entity.Role;
import cn.connext.toolback.entity.User;
import cn.connext.toolback.entity.User_role;
import cn.connext.toolback.service.RoleService;
import cn.connext.toolback.service.Role_perService;
import cn.connext.toolback.service.UserService;
import cn.connext.toolback.service.User_roleService;
import cn.connext.toolback.util.JsonUtils;

import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@Controller
public class RoleAndPermissionController {

    @Autowired
    RoleService roleService;

    @Autowired
    User_roleService user_roleService;

    @Autowired
    UserService userService;

    @Autowired
    Role_perService role_perService;

    @RequestMapping("/editRole")
    @ResponseBody
    public String editRole(@RequestParam("editRoleUserId")int editRoleUserId,
                            @RequestParam("editRoleSeclection0")int editRoleSeclection0,
                           HttpSession session
                           ){
    System.out.println("11111111111111111111111111111111");
    return "";
    }

    @RequestMapping("/addRole")
    @ResponseBody
    public String addRole(@RequestParam("addrolename")String addrolename,
                          @RequestParam("addRoleLevel")int addRoleLevel,
                          @RequestParam("addRoleSlection") JSONArray addRoleSlection,
                          HttpSession session){
        String jsonStr = "{\"errorCode\":\"1\",\"errorMessage\":\"操作成功！\"}";
        return jsonStr;
    }

    @RequestMapping("/editRolePer")
    @ResponseBody
    public String editRolePer(@RequestParam("ediPerRoleId")int ediPerRoleId,
                          @RequestParam("ediPerRoleLevel")int ediPerRoleLevel,
                          @RequestParam("ediPerRoleName")String ediPerRoleName,
                          @RequestParam("ediPerRoleTargetLevel")int ediPerRoleTargetLevel,
                          @RequestParam("ediPerRolePer") JSONArray ediPerRolePer,
                          HttpSession session){
        String jsonStr = "{\"errorCode\":\"4\",\"errorMessage\":\"编辑成功！\"}";
        return jsonStr;
    }

    @RequestMapping("/deleteRolePer")
    @ResponseBody
    public String deleteRole(@RequestParam("ediPerRoleId")int ediPerRoleId,
                             @RequestParam("ediPerRoleLevel")int ediPerRoleLevel,
                             HttpSession session){
        String jsonStr = "{\"errorCode\":\"3\",\"errorMessage\":\"删除成功！\"}";
        return jsonStr;
    }
}
