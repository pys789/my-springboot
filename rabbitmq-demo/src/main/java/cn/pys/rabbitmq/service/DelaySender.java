package cn.pys.rabbitmq.service;

import cn.pys.rabbitmq.config.DelayRabbitConfig;
import cn.pys.rabbitmq.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author:zq
 * @date: Greated in 2019/12/19 11:55
 * 发送者
 */
@Component
public class DelaySender {
    @Autowired
    private AmqpTemplate amqpTemplate;
    private Logger log = LoggerFactory.getLogger(DelaySender.class);

    public void sendDelay(Order order) {
        log.info("【订单生成时间】" + new Date().toString() + "【10秒后检查订单是否已经支付】" + order.toString());
        this.amqpTemplate.convertAndSend(DelayRabbitConfig.ORDER_DELAY_EXCHANGE, DelayRabbitConfig.ORDER_DELAY_ROUTING_KEY, order, message -> {
            // 如果配置了 params.put("x-message-ttl", 5 * 1000);
            // 那么这一句也可以省略,具体根据业务需要是声明 Queue 的时候就指定好延迟时间还是在发送自己控制时间
            message.getMessageProperties().setExpiration(1000 * 10 + "");
            return message;
        });
    }

}