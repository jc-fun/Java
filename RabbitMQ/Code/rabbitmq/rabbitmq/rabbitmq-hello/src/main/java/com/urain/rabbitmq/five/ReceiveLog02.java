package com.urain.rabbitmq.five;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.urain.rabbitmq.utils.RabbitMQUtils;

import java.nio.charset.StandardCharsets;

/**
 * @ClassName: ReceiveLog01
 * @Package: com.urain.rabbitmq.five
 * @Author: urain
 * @Date: 2022/9/23 22:07
 * @Version: 1.0.0
 * @Description: 消息的接收
 */
public class ReceiveLog02 {

    // 交换机的名称
    public static final String EXCHANGE_NAME = "logs";


    public static void main(String[] args) throws Exception {

        Channel channel = RabbitMQUtils.getChannel("192.168.15.114", "admin", "123456");
        // 声明一个交换机
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        // 声明一个队列（临时）
        /**
         * 生成一个临时队列，队列的名称是随机的
         * 当消费者断开与队列的连接的时候，队列就会自动删除
         */
        String queueName = channel.queueDeclare().getQueue();
        /**
         * 绑定交换机与队列
         *
         */
        channel.queueBind(queueName, EXCHANGE_NAME, "");
        System.out.println("等待接收消息，把接收的消息打印在屏幕上......");

        // 接收消息
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("ReceiveLog02控制台打印接收到的消息：" + new String(message.getBody(),
                StandardCharsets.UTF_8));

        };

        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {});
    }

}
