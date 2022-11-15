package com.urain.rabbitmq.three;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import com.urain.rabbitmq.utils.RabbitMQUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: Task2
 * @Package: com.urain.rabbitmq.three
 * @Author: urain
 * @Date: 2022/9/21 23:03
 * @Version: 1.0.0
 * @Description: 消息在手动应答时是不丢失的，放回队列中重新消费
 */
public class Task02 {

    // 队列名称
    public static final String TASK_QUEUE_NAME = "ack_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMQUtils.getChannel("192.168.15.114", "admin", "123456");
        // 开启发布确认
        channel.confirmSelect();
        // 声明队列
        boolean durable = true; // 需要让queue进行持久化
        channel.queueDeclare(TASK_QUEUE_NAME, durable, false, false, null);
        // 从控制台中输入信息
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String message = scanner.next();
            // 设置生产者发送消息为持久化消息
            channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN,
                message.getBytes(StandardCharsets.UTF_8));
            System.out.println("生产者发出消息：" + message);
        }
    }




}
