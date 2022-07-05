package rhr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import rhr.po.Type;
import rhr.service.BlogService;
import rhr.service.TypeService;
import rhr.vo.BlogQuery;

import java.util.List;

@Controller
public class BlogListController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/articals")
    public String blog_list(@PageableDefault(size = 100,sort = {"updateTime"},direction = Sort.Direction.DESC)
                                        Pageable pageable, Model model){
        model.addAttribute("page",blogService.listBlog(pageable));
        model.addAttribute("types",typeService.listTypeTOP(100));
        return "blog_list";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model){
        model.addAttribute("blog",blogService.getBlog(id));

        return "blog";
    }

    @GetMapping("/type/{id}")
    public String search(@PageableDefault(size = 100,sort = {"updateTime"},direction = Sort.Direction.DESC)
                                     Pageable pageable, Model model,@PathVariable Long id){
        BlogQuery blogQuery = new BlogQuery();
        blogQuery.setTypeId(id);
        model.addAttribute("types",typeService.listTypeTOP(100));
        model.addAttribute("page",blogService.listBlog(pageable,blogQuery));
        model.addAttribute("activeTypeId",id);
        return "blog_list";
    }

}
