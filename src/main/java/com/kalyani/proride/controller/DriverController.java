package com.kalyani.proride.controller;

import com.kalyani.proride.model.Driver;
import com.kalyani.proride.service.DriverServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverServiceImpl driverServiceImpl;

    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);

    @GetMapping("/register")
    public String showUserRegistrationForm(Model model) {
        logger.info("Accessing registerDriver endpoint");
        return "driver_register";
    }

    @PostMapping("/register")
    public String registerDriver(@ModelAttribute Driver driver) {
        logger.info("in Driver Registration post api");
        driverServiceImpl.registerDriver(driver);
        return "home";

    }

    @RequestMapping("/hello")
    public ModelAndView sayHello()
    {
        String today= new Date().toString();
        return new ModelAndView("hello", "todaysDate", today);
    }
}
