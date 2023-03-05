package cn.connext.toolback.controller;

import cn.connext.toolback.dto.ShowArticle;
import cn.connext.toolback.entity.Article;
import cn.connext.toolback.entity.Role;
import cn.connext.toolback.entity.Role_per;
import cn.connext.toolback.entity.User;
import cn.connext.toolback.service.*;
import cn.connext.toolback.util.ConvertRole;
import cn.connext.toolback.util.sort.ArticleSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 此控制器主要用于简单的页面跳转
 */
@Controller
public class JumpController {
    @Autowired
    ArticleService articleService;

    @Autowired
    ReplyService replyService;

    @Autowired
    Role_perService role_perService;

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Autowired
    User_roleService user_roleService;

    /**
     * 系统首页
     * @return
     */
    @RequestMapping("/")
    public String toIndex(){
        return "index";
    }

    /**
     * 前往登录页
     * @return
     */
    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }

    /**
     * 登出
     * @param session
     * @return
     */
    @RequestMapping("/tologout")
    public String tologout(HttpSession session){
        session.removeAttribute("rs_user");
        return "index";
    }

    /**
     * 前往权限管理页面
     * @return
     */
    @RequestMapping("/topermission")
    public String topermission(HttpSession session,Model model,HttpServletResponse response){
        return "permission";
    }
    /**
     * 前往注册页面
     * @return
     */
    @RequestMapping("/toregister")
    public String toregister(){
        return "register";
    }

    @RequestMapping("/toarticle")
    public String toarticle(Model model){
        //不启用排序
//        List<Article> articleList=articleService.selectAllArticle(0);
        //启用排序
        List<Article> articleList=articleService.queryAllArticle();

        List<ShowArticle> list=new ArrayList<ShowArticle>();
        if(!list.isEmpty()){
            for(Article t:articleList){
                ShowArticle showArticle=new ShowArticle();
                showArticle.setArticle_id(t.getId());
                showArticle.setArticle_author(t.getAuthor());
                showArticle.setArticle_date(t.getDate());
                showArticle.setArticle_title(t.getTitle());
                showArticle.setCount(replyService.selectAllReplyByArticleID(t.getId()).size()==0?0:replyService.selectAllReplyByArticleID(t.getId()).size());
                showArticle.setReply_date(replyService.selectAllReplyByArticleID(t.getId()).size()==0?null:replyService.selectAllReplyByArticleID(t.getId()).get(0).getDate());
                list.add(showArticle);
            }
            list= ArticleSort.articleSort(list);
            model.addAttribute("list0",list.get(0));
            model.addAttribute("list1",list.get(1));
            model.addAttribute("list2",list.get(2));
        }
        model.addAttribute("page",1);
        return "article";
    }

    @RequestMapping("/toGaofengpaiban")
    public String toGaofengpaiban(Model model){
        return "gaofengpaiban";
    }

    @RequestMapping("/toTestElement")
    public String toTestElement(Model model){
        return "testElement";
    }


    @RequestMapping("/tomyarticle")
    public String tomyarticle(HttpSession session, Model model, HttpServletResponse response){
        User user= (User) session.getAttribute("rs_user");
        if (user==null){
            response.setContentType("text/html; charset=UTF-8"); //转码
            PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.flush();
            out.println("<script>");
            out.println("alert('您当前尚未登陆，请先登录！');");
            out.println("history.back();");
            out.println("</script>");
            return "article";
        }
        int id=user.getId();
        //不启用排序
//        List<Article> articleList=articleService.selectArticleByUserId(id,0);
        //启用排序
        List<Article> articleList=articleService.selectAllArticleByUserId(id);
        List<ShowArticle> list=new ArrayList<ShowArticle>();
        for(Article t:articleList){
            ShowArticle showArticle=new ShowArticle();
            showArticle.setArticle_id(t.getId());
            showArticle.setArticle_author(t.getAuthor());
            showArticle.setArticle_date(t.getDate());
            showArticle.setArticle_title(t.getTitle());
            showArticle.setCount(replyService.selectAllReplyByArticleID(t.getId()).size()==0?0:replyService.selectAllReplyByArticleID(t.getId()).size());
            showArticle.setReply_date(replyService.selectAllReplyByArticleID(t.getId()).size()==0?null:replyService.selectAllReplyByArticleID(t.getId()).get(0).getDate());
            list.add(showArticle);
        }
        list= ArticleSort.articleSort(list);
        if (list.size()>0&&list.get(0)!=null)
        model.addAttribute("list0",list.get(0));
        if (list.size()>1&&list.get(1)!=null)
        model.addAttribute("list1",list.get(1));
        if (list.size()>2&&list.get(2)!=null)
        model.addAttribute("list2",list.get(2));
        model.addAttribute("mypage",1);
        return "myarticle";
    }

    @RequestMapping("/test")
    public String test(){
        return "articleDetail";
    }

    @RequestMapping("/queryPermission")
    public String queryPermission(@RequestParam("id")int id,Model model){
        Role myRole=roleService.selectRoleById(id);
        List<Role_per> list=role_perService.selectPermission(myRole.getId());

        List myPermission=new ConvertRole().toList(list);

        model.addAttribute("myRole",myRole);

        model.addAttribute("myPermission",myPermission);
        return "selectPermission";
    }

}
