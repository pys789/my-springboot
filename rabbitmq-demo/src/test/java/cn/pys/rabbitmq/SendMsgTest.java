package cn.pys.rabbitmq;

import cn.pys.rabbitmq.service.SendService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by pengys on 2022/3/28
 */
class SendMsgTest extends RabbitmqDemoApplicationTests {

    @Autowired
    private SendService sendService;

    @Test
    void testSendMsg(){
        sendService.sendMessage("confirmTestExchange","","生成者消息发送测试");
    }



}
