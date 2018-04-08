package com.example.shoppingwebapplication.ProductController;

import com.example.shoppingwebapplication.Entity.User;
import com.example.shoppingwebapplication.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public String save(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "register";
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        userService.saveUser(user);
        return "redirect:/login";
    }

}
