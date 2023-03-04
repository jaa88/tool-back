package cn.connext.yonyong.yonyongbbs.controller;

import cn.connext.yonyong.yonyongbbs.dto.ShowArticle;
import cn.connext.yonyong.yonyongbbs.entity.*;
import cn.connext.yonyong.yonyongbbs.service.*;
import cn.connext.yonyong.yonyongbbs.util.ConvertRole;
import cn.connext.yonyong.yonyongbbs.util.sort.ArticleSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *  此控制器主要用于处理分页
 */
@Controller
public class PageController {
    @Autowired
    ArticleService articleService;

    @Autowired
    ReplyService replyService;

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Autowired
    Role_perService role_perService;

    @Autowired
    User_roleService user_roleService;

    @RequestMapping("/page")
    public String page(@RequestParam("page")int page, Model model){
        //如果传递过来的页数<1或者传过来的页数能展示的信息超过了数据库里的条数，即会空出一页或者更多，则将页数置为1
        int tpage=page;
        int rs=articleService.queryAllArticle().size();
        if(page<1||(page-1)*3>=rs)
            tpage=1;

        List<Article> articleList=articleService.queryAllArticle();
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
    System.out.println("page的值为："+tpage);
        if (list.size()>((tpage-1)*3)&&list.get((tpage-1)*3)!=null)
        model.addAttribute("list0",list.get((tpage-1)*3));
        if (list.size()>((tpage-1)*3+1)&&list.get((tpage-1)*3+1)!=null)
        model.addAttribute("list1",list.get((tpage-1)*3+1));
        if (list.size()>((tpage-1)*3+2)&&list.get((tpage-1)*3+2)!=null)
        model.addAttribute("list2",list.get((tpage-1)*3+2));
        model.addAttribute("page",tpage);
        return "article";
    }

    @RequestMapping("/mypage")
    public String mypage(@RequestParam("mypage")int mypage, Model model, HttpSession session){
        //如果传递过来的页数<1或者传过来的页数能展示的信息超过了数据库里的条数，即会空出一页或者更多，则将页数置为1
       int tmypage=mypage;
        User user= (User) session.getAttribute("rs_user");
        int id=user.getId();
        int rs=articleService.selectAllArticleByUserId(id).size();
        if(mypage<1||(mypage-1)*3>=rs)
            tmypage=1;

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
        System.out.println("mypage的值为："+tmypage);
        if (list.size()>((tmypage-1)*3)&&list.get((tmypage-1)*3)!=null)
            model.addAttribute("list0",list.get((tmypage-1)*3));
        if (list.size()>((tmypage-1)*3+1)&&list.get((tmypage-1)*3+1)!=null)
            model.addAttribute("list1",list.get((tmypage-1)*3+1));
        if (list.size()>((tmypage-1)*3+2)&&list.get((tmypage-1)*3+2)!=null)
            model.addAttribute("list2",list.get((tmypage-1)*3+2));
        model.addAttribute("mypage",tmypage);
        return "myarticle";
    }

    @RequestMapping("/replypage")
    public String replypage(@RequestParam("replypage")int replypage, @RequestParam("articleid")int articleid,Model model){
        int rs=replyService.selectAllReplyByArticleID(articleid).size();
        //如果传递过来的页数<1或者传过来的页数能展示的信息超过了数据库里的条数，即会空出一页或者更多，则将页数置为1
        if (replypage<1||(replypage-1)*3>=rs)
            replypage=1;
        Article article=articleService.selectArticleById(articleid);
        model.addAttribute("article",article);
        List<Reply> replies=replyService.selectAllReply(articleid,(replypage-1)*3);
        if(replies.size()>0&&replies.get(0)!=null)
            model.addAttribute("reply0",replies.get(0));
        if(replies.size()>1&&replies.get(1)!=null)
            model.addAttribute("reply1",replies.get(1));
        if(replies.size()>2&&replies.get(2)!=null)
            model.addAttribute("reply2",replies.get(2));
        model.addAttribute("replypage",replypage);
        model.addAttribute("articleid",articleid);
        return "articleDetail";
    }

    @RequestMapping("/userpage")
    public String userpage(@RequestParam("userpage")int userpage, Model model, HttpSession session){

        return "permission";
    }

    @RequestMapping("/rolepage")
    public String rolepage(@RequestParam("rolepage")int rolepage, Model model, HttpSession session){
        return "permission";
    }

}
