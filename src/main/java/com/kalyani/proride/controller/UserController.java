package com.kalyani.proride.controller;


import com.kalyani.proride.model.User;
import com.kalyani.proride.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/register")
    public String showUserRegistrationForm(Model model) {
        logger.info("in User Registration get api");
        model.addAttribute("user", new User());
        return "user_register";
    }

    @PostMapping("/register")
    @Transactional
    public String registerUser(@ModelAttribute("user") User user) {
        logger.info("in User Registration post api");
        userServiceImpl.registerUser(user);
        return "home";
    }

}
