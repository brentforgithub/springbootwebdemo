package com.brent.demo.controller;

import com.brent.demo.common.basecontroller.BaseC;
import com.brent.demo.common.basecontroller.ResBody;
import com.brent.demo.common.exception.BusinessException;
import com.brent.demo.config.DemoConfig;
import com.brent.demo.dao.NameDemoMapper;
import com.brent.demo.mode.po.NameDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController extends BaseC{

    @Autowired
    private DemoConfig demoConfig;

    @Autowired
    private NameDemoMapper nameDemoMapper;

    @RequestMapping(value = "/hello",method = {RequestMethod.GET})
    @ResponseBody
    public String hello() {
        return "Hello World " +  demoConfig.getProperty();
    }

    @RequestMapping(value = "/showDemo",method = {RequestMethod.GET})
    @ResponseBody
    public ResBody<NameDemo> showDemo(@RequestParam Integer id) {
        if(id == 2){
            throw new RuntimeException("出现错误！");
        }

        if(id == 3){
            throw new BusinessException("出现错误！");
        }

        if(id == 4){
            throw new BusinessException(100,"出现错误！");
        }
        return createSuccessBody(nameDemoMapper.selectByPrimaryKey(id));
    }

}
