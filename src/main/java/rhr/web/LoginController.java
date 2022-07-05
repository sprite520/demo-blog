package rhr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rhr.po.User;
import rhr.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginpage1(){
        return "register";
    }

    @GetMapping("/")
    public String loginpage2(){
        return "register";
    }

    @RequestMapping("/login/check")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes) {
        User user = userService.checkUser(username, password);
        if(user != null) {
            user.setPassword(null);
            session.setAttribute("user",user);
            return "redirect:/index";
        }
        else{
            attributes.addFlashAttribute("message","用户名或密码错误");
            return "redirect:/login";
        }
    }

    @GetMapping("/login/sign_up")
    public String signup(){
        return "sign_up";
    }

    @GetMapping("/login/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/login";
    }
}
