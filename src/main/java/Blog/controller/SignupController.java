package Blog.controller;

import Blog.model.User;
import Blog.service.UserService;
import Blog.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@SessionAttributes("user")
public class SignupController {
    private final UserService userService;
    @Autowired
            public SignupController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String getRegisterForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "registerForm";
    }

    @PostMapping("/register")
    public User signup(@RequestBody User user){
        return userService.saveUser(user);
    }
}