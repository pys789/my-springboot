package com.pys.demo.controller;

import com.pys.config.HelloServiceConfiguration;
import com.pys.demo.config.AutoConfig;
import com.pys.demo.entity.MyEnableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {


    @Resource
    MyEnableBean myAutoBean;

    @Autowired
    private HelloServiceConfiguration helloServiceConfiguration;

    // 自动装配，不需要使用注解引入
    @Resource
    AutoConfig autoConfig;

    @GetMapping("/hello")
    public String hello() {
        System.out.println(myAutoBean.hello("myAutoBean"));
        System.out.println(autoConfig.myAutoBean3());
        return "Hello Spring Boot!";
    }

    /**
     * 测试定义starter
     *
     * @return
     */
    @GetMapping("/starter")
    public String starter() {
        return helloServiceConfiguration.getName() + "," + helloServiceConfiguration.getHobby();
    }

}