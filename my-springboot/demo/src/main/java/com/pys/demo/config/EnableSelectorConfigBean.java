package com.pys.demo.config;

import com.pys.demo.entity.MyEnableSelectorBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnableSelectorConfigBean {
    @Bean
    public MyEnableSelectorBean autoSelectorBean() {
        System.out.println("------------我是 @EnableSelectorConfigAnno 时的手动装配--------");
        return new MyEnableSelectorBean();
    }

}
