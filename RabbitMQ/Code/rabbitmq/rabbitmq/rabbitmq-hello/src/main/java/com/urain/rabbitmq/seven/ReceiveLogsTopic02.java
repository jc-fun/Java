package com.urain.rabbitmq.seven;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.urain.rabbitmq.utils.RabbitMQUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: ReceiveLogs
 * @Package: com.urain.rabbitmq.seven
 * @Author: urain
 * @Date: 2022/9/25 20:26
 * @Version: 1.0.0
 * @Description: 声明主题交换机及相关队列
 * 消费者C1
 *
 */
public class ReceiveLogsTopic02 {

    // 交换机的名称
    public static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws IOException, TimeoutException {

        Channel channel = RabbitMQUtils.getChannel("192.168.15.114", "admin", "123456");
        // 声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        // 声明队列
        String queueName = "Q2";
        channel.queueDeclare(queueName, false, false, false, null);
        channel.queueBind(queueName, EXCHANGE_NAME, "*.*.rabbit");
        channel.queueBind(queueName, EXCHANGE_NAME, "lazy.#");
        System.out.println("等待接收消息......");
        DeliverCallback deliverCallback  = (consumerTag, message) -> {
            System.out.println(new String(message.getBody(), StandardCharsets.UTF_8));
            System.out.println("接收队列：" + queueName + "，绑定键：" + message.getEnvelope().getRoutingKey());
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {});

    }



}
