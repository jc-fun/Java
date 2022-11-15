package com.urain.rabbitmq.two;

import com.rabbitmq.client.Channel;
import com.urain.rabbitmq.utils.RabbitMQUtils;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: Task01
 * @Package: com.urain.rabbitmq.two
 * @Author: urain
 * @Date: 2022/9/20 8:57
 * @Version: 1.0.0
 * @Description: 生产者 发送大量消息
 */
public class Task01 {

    // 队列名称
    public static final String QUEUE_NAME = "hello";

    // 发送大量消息
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMQUtils.getChannel("192.168.15.114", "admin", "123456");
        // 队列的声明
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 从控制台当中接收信息
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String message = scanner.next();
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("消息发送完成：" + message);
        }
    }


}
