package com.brent.demo.controller;

import com.brent.demo.config.DemoConfig;
import com.brent.demo.dao.NameDemoMapper;
import com.brent.demo.mode.po.NameDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoConfig demoConfig;

    @Autowired
    private NameDemoMapper nameDemoMapper;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello World " +  demoConfig.getProperty();
    }

    @RequestMapping("/showDemo")
    @ResponseBody
    public NameDemo showDemo(@RequestParam Integer id) {
        return nameDemoMapper.selectByPrimaryKey(id);
    }


}
