package com.pys.demo.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * author: pengys
 * date: 2022/1/19
 * description: spring初始化后调用的事件监听代码
 */
@Component
public class ApplicationListenerTest implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("spring初始化后发布的ContextRefreshedEvent事件");
    }
}
