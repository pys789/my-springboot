package com.pys.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Author: pengys
 * @Description:
 */
@Aspect
public class MyAspect {

    @Pointcut("execution(* com.pys.demo.service.MyService.*(..))")
    public void pointCut(){
    }

    @Before("pointCut()")
    public void before(){
        System.out.println("执行before()方法");
    }


}
