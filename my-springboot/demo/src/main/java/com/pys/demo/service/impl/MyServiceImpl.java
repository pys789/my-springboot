package com.pys.demo.service.impl;

import com.pys.demo.service.MyService;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {

    public MyServiceImpl(){
        System.out.println("-----------AOP代理断点debug处-----------");
    }

    public void test(){
        System.out.println("运行test方法");
    }
}