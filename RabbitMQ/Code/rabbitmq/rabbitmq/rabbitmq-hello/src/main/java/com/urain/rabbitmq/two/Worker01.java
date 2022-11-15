package com.urain.rabbitmq.two;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.urain.rabbitmq.utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: Worker01
 * @Package: com.urain.rabbitmq.two
 * @Author: urain
 * @Date: 2022/9/20 8:41
 * @Version: 1.0.0
 * @Description: 这是一个工作线程（相当于之前的消费者）
 */
public class Worker01 {

    // 队列名称
    public static final String QUEUE_NAME = "hello";

    // 接收消息
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMQUtils.getChannel("192.168.15.114", "admin", "123456");

        // 消息接收后的回调
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("接收到的消息:" + new String(message.getBody()));
        };
        // 取消接收时的回调
        CancelCallback cancelCallback = (consumerTag) -> {
            System.out.println("消息被消费者取消消费的回调");
        };

        // 消息的接收
        System.out.println("C2等待接收消息......");
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
    }


}
