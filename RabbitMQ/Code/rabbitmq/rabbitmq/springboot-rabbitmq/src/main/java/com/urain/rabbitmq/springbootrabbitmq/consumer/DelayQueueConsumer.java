package com.urain.rabbitmq.springbootrabbitmq.consumer;

import com.urain.rabbitmq.springbootrabbitmq.config.DelayedQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName: DelayQueueConsumer
 * @Package: com.urain.rabbitmq.springbootrabbitmq.consumer
 * @Author: urain
 * @Date: 2022/9/29 20:47
 * @Version: 1.0.0
 * @Description: 消费者  基于插件的延迟消息
 */
@Component
@Slf4j
public class DelayQueueConsumer {

    // 监听消息
    @RabbitListener(queues = DelayedQueueConfig.DELAYED_QUEUE_NAME)
    public void receiveDelayQueue(Message message) {
        String msg = new String(message.getBody());
        log.info("当前时间：{}，收到延迟队列的消息：{}", new Date(), msg);
    }


}
