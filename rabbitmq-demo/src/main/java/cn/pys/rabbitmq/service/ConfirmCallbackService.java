package cn.pys.rabbitmq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * 消息只要被 rabbitmq broker 接收到就会触发 confirmCallback 回调
 */
@Component
public class ConfirmCallbackService implements RabbitTemplate.ConfirmCallback {

    private Logger log = LoggerFactory.getLogger(ConfirmCallbackService.class);

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (!ack) {
            log.info("消息发送异常!");
        } else {
            log.info("收到确认，correlationData={} ,ack={}, cause={}", correlationData.getId(), ack, cause);
        }
    }
}