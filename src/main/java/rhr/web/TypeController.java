package rhr.web;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rhr.po.Type;
import rhr.service.TypeService;

@Controller
public class TypeController {

    @Autowired
    TypeService typeService;

    @GetMapping("/types")
    public String types (@PageableDefault(size=100,sort={"id"},direction = Sort.Direction.DESC)
                                     Pageable pageable, Model model){
        model.addAttribute("page",typeService.listType(pageable));
        return "type_admin";
    }

    @GetMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type",new Type());
        return "type_input";
    }

    @GetMapping("/types/{id}/input")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("type",typeService.getType(id));
        return "type_input";
    }

    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        typeService.deleteType(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/types";
    }

    @GetMapping("/types/post")
    public String post(Type type, RedirectAttributes attributes){
        Type type1=new Type();
        if(type.getId()==null) {
             type1 = typeService.saveType(type);
        }else{
            type1=typeService.update(type.getId(),type);
        }
        if(type1==null){
            attributes.addFlashAttribute("message","提交失败");
        }else{
            attributes.addFlashAttribute("message","提交成功");
        }
        return "redirect:/types";
    }

}

