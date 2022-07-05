package rhr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rhr.dao.CommentRepository;
import rhr.po.Blog;
import rhr.po.User;
import rhr.service.BlogService;
import rhr.service.TypeService;
import rhr.vo.BlogQuery;
import rhr.po.Comment;
import rhr.service.CommentService;
import rhr.service.UserService;
import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;



@Controller
public class CommentController {
    @Autowired
    private CommentService CommentService;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserService userService;

    @RequestMapping("/showcomments")
    public String showcomments(ModelMap map){
        List<Comment>commentList=commentRepository.findAll();
        map.addAttribute("comments",commentList);
        return "message";
    }


    @GetMapping("/savemessage")
    public String save_message(@RequestParam String content )
    {
        if(content!=null)
        {
            CommentService.savemessage(content);

            return "redirect:/showcomments";
        }
        else
        {
            return "index";
        }
    }
}
