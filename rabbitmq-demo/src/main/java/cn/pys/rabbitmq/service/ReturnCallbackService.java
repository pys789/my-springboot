package cn.pys.rabbitmq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * 如果消息未能投递到目标 queue 里将触发回调 returnCallback
 */
@Component
public class ReturnCallbackService implements RabbitTemplate.ReturnsCallback {

    private Logger log = LoggerFactory.getLogger(ReturnCallbackService.class);

    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {
        log.info("returnedMessage ===> returnedMessage={}", returnedMessage);
    }
}