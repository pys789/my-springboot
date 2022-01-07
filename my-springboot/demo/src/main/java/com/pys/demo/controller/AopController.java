package com.pys.demo.controller;

import com.pys.demo.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: pengys
 * @Description:
 */
@RestController
public class AopController {

    @Autowired
    private MyService myService;

    @RequestMapping("aop")
    public String test(){
        myService.test();
        return "ok";
    }
}
