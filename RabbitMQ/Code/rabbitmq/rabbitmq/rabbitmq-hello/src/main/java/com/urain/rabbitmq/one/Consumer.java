package com.urain.rabbitmq.one;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: Consumer
 * @Package: com.urain.rabbitmq.one
 * @Author: urain
 * @Date: 2022/9/19 22:27
 * @Version: 1.0.0
 * @Description: 消费者：接收消息
 */
public class Consumer {

    // 队列的名称
    public static final String QUEUE_NAME = "hello";
    // 接收消息
    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.15.114");
        factory.setUsername("admin");
        factory.setPassword("123456");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        /**
         * 消费者接收消息
         * 1.消费哪个队列
         * 2.消费成功之后是否要自动应答
         * 3.消费者未成功消费的回调
         * 4.消费者取消消费的回调
         */
        channel.basicConsume(QUEUE_NAME, true, (consumerTag, message) -> {
            System.out.println(new String(message.getBody()));
        }, (consumerTag -> {
            System.out.println("消息消费被中断");
        }));


    }


}
