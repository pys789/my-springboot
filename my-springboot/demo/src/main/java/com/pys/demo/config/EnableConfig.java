package com.pys.demo.config;

import com.pys.demo.entity.MyEnableBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnableConfig {
    @Bean
    public MyEnableBean autoConfigBean() {
        System.out.println("--------我是 @EnableConfig 时的手动装配--------");
        return new MyEnableBean();
    }

}
