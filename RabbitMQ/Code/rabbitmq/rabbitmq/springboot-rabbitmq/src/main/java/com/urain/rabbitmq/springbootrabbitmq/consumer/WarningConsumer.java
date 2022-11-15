package com.urain.rabbitmq.springbootrabbitmq.consumer;

import com.urain.rabbitmq.springbootrabbitmq.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: WarningConsumer
 * @Package: com.urain.rabbitmq.springbootrabbitmq.consumer
 * @Author: urain
 * @Date: 2022/10/15 23:11
 * @Version: 1.0.0
 * @Description: TODO
 */
@Component
@Slf4j
public class WarningConsumer {

    // 接收报警消息
    @RabbitListener(queues = ConfirmConfig.WARNING_QUEUE_NAME)
    public void receiveWarningMsg(Message message) {
        String msg = new String(message.getBody());
        log.error("报警发现不可路由消息：{}", msg);
    }


}
