package com.kalyani.proride.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/driver")
public class DriverController {

    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);

    @GetMapping("/registerDriver")
    @ResponseBody
    public String registerDriver() {
        logger.info("Accessing registerDriver endpoint");
        return "Driver Registration Page";
    }

    @RequestMapping("/hello")
    public ModelAndView sayHello()
    {
        String today= new Date().toString();
        return new ModelAndView("hello", "todaysDate", today);
    }
}
