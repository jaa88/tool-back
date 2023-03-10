package cn.connext.toolback.controller;

import cn.connext.toolback.entity.Article;
import cn.connext.toolback.entity.Reply;
import cn.connext.toolback.entity.User;
import cn.connext.toolback.service.*;
import cn.connext.toolback.util.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @Autowired
    ReplyService replyService;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    Role_perService role_perService;

    @Autowired
    License license;

    @Autowired
    User_roleService user_roleService;

    /**
     * 跳转到消息详情页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/article")
    public String article(@RequestParam("id")int id, Model model){
        Article article=articleService.selectArticleById(id);
        List<Reply> replies=replyService.selectAllReplyByArticleID(id);
        model.addAttribute("article",article);
        if(replies.size()>0&&replies.get(0)!=null)
            model.addAttribute("reply0",replies.get(0));
        if(replies.size()>1&&replies.get(1)!=null)
            model.addAttribute("reply1",replies.get(1));
        if(replies.size()>2&&replies.get(2)!=null)
            model.addAttribute("reply2",replies.get(2));
        model.addAttribute("replypage",1);
        model.addAttribute("articleid",id);
        return "articleDetail";
    }

    @RequestMapping("/addArticle")
    @ResponseBody
    public String addArticle(@RequestParam("addArticleTitle")String addArticleTitle,
                             @RequestParam("addArticleContent")String addArticleContent,
                                HttpSession session){

        return "";
    }

    @RequestMapping("/editArticle")
    @ResponseBody
    public String editArticle(@RequestParam("editArticleId")String editArticleId, //修改的文章的userid
                              @RequestParam("editArticleTitle")String editArticleTitle,
                              @RequestParam("editArticleContent")String editArticleContent,
                              @RequestParam("articleId")int articleId,
                              HttpSession session){
        String jsonStr = "{\"errorCode\":\"1\",\"errorMessage\":\"更新成功！\"}";
        return jsonStr;
    }

    @RequestMapping("/deleteArticle")
    @ResponseBody
    public String editArticle(@RequestParam("articleId")int articleId,@RequestParam("deleteArticleId")int deleteArticleId,
                              HttpSession session){
        String jsonStr = "{\"errorCode\":\"1\",\"errorMessage\":\"删除成功！\"}";
        return jsonStr;
    }

    @RequestMapping("/addReply")
    @ResponseBody
    public String addReply(@RequestParam("articleId")int articleId,
                           @RequestParam("reply_content")String reply_content,
                           HttpSession session){
      return "";
    }
}
