package com.pys.demo;

import com.pys.demo.annotation.EnableConfigAnno;
import com.pys.demo.annotation.EnableSelectorConfigAnno;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableConfigAnno
@EnableSelectorConfigAnno
public class Demo {
    public static void main(String[] args) {
        SpringApplication.run(Demo.class,args);
    }
}
