package cn.pys.rabbitmq.controller;

import cn.pys.rabbitmq.entity.Order;
import cn.pys.rabbitmq.service.DelaySender;
import cn.pys.rabbitmq.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by pengys on 2022/3/28
 */
@RestController
@RequestMapping("msg")
public class SendMsgController {
    @Autowired
    SendService sendService;

    @Autowired
    DelaySender delaySender;

    // 测试消息确认
    @GetMapping(value = "/send/{id}")
    public String confirmTest(@PathVariable(value = "id") Integer id) {
        // 发送者开启 confirm 确认机制，接收 ConfirmCallbackService 的回调
        // 发送者开启 return 确认机制，如果消息未能投递到目标 queue 里将触发回调 returnCallback
        sendService.sendMessage("confirmTestExchange", "", "消息:" + id);
        return "发送成功";
    }

    // 测试direct消息发送消费工作模式
    @GetMapping(value = "/direct/{id}")
    public String findByUserId(@PathVariable(value = "id") Integer id) {
        sendService.sendMessage("test_direct_exchange", "direct_test", "消息:" + id);
        return "发送成功";
    }

    @GetMapping(value = "/dlx/{id}")
    public String dlxTest(@PathVariable(value = "id") Integer id) {
        delaySender.sendDelay(new Order(id + "", 0, "orderName:" + id));
        return "发送成功";
    }
}
