package rhr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rhr.dao.UserRepository;
import rhr.po.User;
import rhr.service.UserService;

import java.util.List;

@Controller
public class SignUpController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/login/sign_up/check")
    public String signup_check(@RequestParam String username,
                               @RequestParam String password,
                               RedirectAttributes attributes){
        User user = userService.checkUser(username, password);
        if(user!=null){
            attributes.addFlashAttribute("message","注册失败!");
            return "redirect:/login/sign_up";
        }
        else{
            userService.saveUser(username,password);
            return "register";
        }
    }

    @GetMapping("/listuserinfo")
    public String showuserinfo(ModelMap map){
        List<User> userList=userRepository.findAll();
        map.addAttribute("usi",new User());
        return "user";
    }

    @RequestMapping("/saveuserinfo")
    public String save_userinfomation(User usi){
        userRepository.save(usi);
        return "redirect:/index";
    }
}
