package com.pys.demo.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: pengys
 * @Description:
 */
@Configuration
public class AopConfig {

    @Bean
    public MyAspect myAspect(){
        return new MyAspect();
    }
}
