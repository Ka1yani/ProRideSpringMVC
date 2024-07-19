package com.kalyani.proride.controller;


import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.logging.Logger;

@Controller
@RequestMapping("/ride")
public class RideController {

    @RequestMapping("/hello")
    public ModelAndView sayHello()
    {
        String today= new Date().toString();
        return new ModelAndView("hello", "todaysDate", today);
    }

}
