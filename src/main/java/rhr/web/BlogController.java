package rhr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rhr.po.Blog;
import rhr.po.User;
import rhr.service.BlogService;
import rhr.service.TypeService;
import rhr.vo.BlogQuery;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/blogs")
    public String blogs(@PageableDefault(size = 100,sort = {"updateTime"},direction = Sort.Direction.DESC)
                                    Pageable pageable, BlogQuery blog, Model model){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("page",blogService.listBlog(pageable,blog));
        return "blog_admin";
    }

    @GetMapping("/blogs/search")
    public String search(@PageableDefault(size = 100,sort = {"updateTime"},direction = Sort.Direction.DESC)
                         Pageable pageable,BlogQuery blog,Model model){
        model.addAttribute("page",blogService.listBlog(pageable,blog));
        return "blog_admin";
    }

    @GetMapping("/blogs/input")
    public String input(Model model){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("blog",new Blog());
        return "blog_input";
    }

    @GetMapping("/blogs/{id}/input")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("blog",blogService.getBlog(id));
        return "blog_input";
    }

    @GetMapping("/blogs/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        blogService.deleteBlog(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/blogs";
    }


    @GetMapping("/blogs/post")
    public String post(Blog blog, RedirectAttributes attributes, HttpSession session){

        blog.setUser((User) session.getAttribute("user"));
        blog.setType(typeService.getType(blog.getType().getId()));
        Blog blog1;

        if(blog.getId()==null){
            blog1=blogService.saveBlog(blog);
        }else{
            blog1=blogService.updateBlog(blog.getId(),blog);
        }

        if(blog1==null){
            attributes.addFlashAttribute("message","提交失败");
        }else {
            attributes.addFlashAttribute("message","提交成功");
        }
        return "redirect:/blogs";
    }


}

