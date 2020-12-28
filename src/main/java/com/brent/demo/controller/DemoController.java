package com.brent.demo.controller;

import com.brent.demo.config.DemoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoConfig demoConfig;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello World " +  demoConfig.getProperty();
    }


}
