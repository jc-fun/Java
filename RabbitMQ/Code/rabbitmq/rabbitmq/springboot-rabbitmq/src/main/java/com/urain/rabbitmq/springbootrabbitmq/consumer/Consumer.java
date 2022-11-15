package com.urain.rabbitmq.springbootrabbitmq.consumer;

import com.urain.rabbitmq.springbootrabbitmq.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: Consumer
 * @Package: com.urain.rabbitmq.springbootrabbitmq.consumer
 * @Author: urain
 * @Date: 2022/9/29 21:40
 * @Version: 1.0.0
 * @Description: 接收消息
 */

@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = ConfirmConfig.CONFIRM_QUEUE_NAME)
    public void receiveConfirmMessage(Message message) {

        String msg = new String(message.getBody());
        log.info("接受到的队列confirm.queue消息：{}", msg);

    }


}
