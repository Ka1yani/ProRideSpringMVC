package com.kalyani.proride.controller;


import com.kalyani.proride.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/registerUser")
    public String showUserRegistrationForm() {
        System.out.println("here");
        return "user_register";
    }

}
