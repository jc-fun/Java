package com.urain.rabbitmq.one;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.HashMap;

/**
 * @ClassName: Producer
 * @Package: com.urain.rabbitmq.one
 * @Author: urain
 * @Date: 2022/9/19 22:12
 * @Version: 1.0.0
 * @Description: 生产者：发消息
 */
public class Producer {

    // 队列名称
    public static final String QUEUE_NAME = "hello";

    // 发消息
    public static void main(String[] args) throws Exception {
        // 创建一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 工厂IP 连接RabbitMQ队列
        factory.setHost("192.168.15.114");
        // 用户名 密码
        factory.setUsername("admin");
        factory.setPassword("123456");
        // 创建连接
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        /**
         * 创建一个队列
         * 1.队列名称
         * 2.队列里的消息是否持久化，默认存储在内存中不进行持久化
         * 3.该对列是否只供一个消费者进行消费，是否进行消息共享
         * 4.是否自动删除，最后一个消费者断开连接后，该队列是否自动删除
         * 5.其它参数
         */

        var arguments = new HashMap<String, Object>(1);
        arguments.put("x-max-priority", 10); // 官方允许优先级在0-255之间。此处设置为10，允许优先级范围为0-10，不要设置过大，浪费cpu与内存
        channel.queueDeclare(QUEUE_NAME, true, false, false, arguments);
        // 发消息
        for (int i = 1; i < 11; i++) {
            String message = "info" + i;
            if (i == 5) {
                /**
                 * 发送一个消息
                 * 1.发送到哪个交换机
                 * 2.路由的Key值是哪个 本次是队列的名称
                 * 3.其它参数信息
                 * 4.发送消息的消息体
                 */
                AMQP.BasicProperties properties = new AMQP.BasicProperties().builder().priority(5).build();
                channel.basicPublish("", QUEUE_NAME, properties, message.getBytes());
            } else {
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            }
        }
        System.out.println("消息发送完毕");
    }


}
