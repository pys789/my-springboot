package com.pys.demo.config;

import com.pys.demo.entity.AutoConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoConfig {
    @Bean
    public AutoConfigBean myAutoBean3() {
        System.out.println("------------我是自动装配，不需要加入注解引入，读取 spring.factories 文件自动装配--------");
        return new AutoConfigBean();
    }

}
