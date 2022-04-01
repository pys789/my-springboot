package cn.pys.rabbitmq.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by pengys on 2022/3/28
 */
@Configuration
public class QueueConfig {

    @Bean(name = "confirmTestQueue")
    public Queue confirmTestQueue() {
        return new Queue("confirm_test_queue", true, false, false);
    }

    @Bean(name = "confirmTestExchange")
    public FanoutExchange confirmTestExchange() {
        return new FanoutExchange("confirmTestExchange");
    }

    @Bean
    public Binding confirmTestFanoutExchangeAndQueue(
            @Qualifier("confirmTestExchange") FanoutExchange confirmTestExchange,
            @Qualifier("confirmTestQueue") Queue confirmTestQueue) {
        return BindingBuilder.bind(confirmTestQueue).to(confirmTestExchange);
    }

    /**
     * 测试direct类型的消费
     */
    @Bean(name = "testDirectQueue")
    public Queue testDirectQueue() {
        return new Queue("test_direct_queue", true, false, false);
    }

    @Bean(name = "testDirectExchange")
    public DirectExchange testDirectExchange() {
        return new DirectExchange("test_direct_exchange");
    }

    @Bean
    public Binding testDirectExchangeAndQueue(
            @Qualifier("testDirectExchange") DirectExchange testDirectExchange,
            @Qualifier("testDirectQueue") Queue testDirectQueue) {
        return BindingBuilder.bind(testDirectQueue).to(testDirectExchange).with("direct_test");
    }

}
