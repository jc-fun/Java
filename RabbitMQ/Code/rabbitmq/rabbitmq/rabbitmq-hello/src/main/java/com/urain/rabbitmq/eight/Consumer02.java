package com.urain.rabbitmq.eight;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.urain.rabbitmq.utils.RabbitMQUtils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Consumer01
 * @Package: com.urain.rabbitmq.eight
 * @Author: urain
 * @Date: 2022/9/25 21:25
 * @Version: 1.0.0
 * @Description: 死信队列实战
 * 消费者1
 *
 */
public class Consumer02 {

    // 死信队列的名称
    public static final String DEAD_QUEUE = "dead_queue";

    public static void main(String[] args) throws Exception {

        Channel channel = RabbitMQUtils.getChannel("192.168.15.114", "admin", "123456");

        System.out.println("等待接收消息......");

        channel.basicConsume(DEAD_QUEUE, true, (consumerTag, message) -> {
            System.out.println("Consumer02接收的消息是：" + new String(message.getBody(), StandardCharsets.UTF_8));
        }, consumerTag -> {});


    }







}
