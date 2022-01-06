package com.pys.ds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// 禁用数据源自动配置
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DynamicDataSourceDemo {
    public static void main(String[] args) {
        SpringApplication.run(DynamicDataSourceDemo.class,args);
    }
}
