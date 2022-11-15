package com.urain.rabbitmq.three;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;
import com.urain.rabbitmq.utils.RabbitMQUtils;
import com.urain.rabbitmq.utils.SleepUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: Worker03
 * @Package: com.urain.rabbitmq.three
 * @Author: urain
 * @Date: 2022/9/21 23:12
 * @Version: 1.0.0
 * @Description: 消息在手动应答时是不丢失的，放回队列中重新消费
 */
public class Worker03 {

    // 队列名称
    public static final String TASK_QUEUE_NAME = "ack_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMQUtils.getChannel("192.168.15.114", "admin", "123456");
        System.out.println("C1等待接收消息，处理时间较短");

        DeliverCallback deliverCallback = (String consumerTag, Delivery message) -> {
            // 沉睡1s
            SleepUtils.sleep(1);
            System.out.println("接收到的消息：" + new String(message.getBody(), StandardCharsets.UTF_8));
            // 手动应答
            /**
             * 1.消息的标记 tag
             * 2.是否批量应答
             */
            channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
        };
        // 设置不公平分发
        int prefetchCount = 1;
        // prefetchCount  预取值
        channel.basicQos(prefetchCount);
        // 采用手动应答
        boolean autoAck = false;
        channel.basicConsume(TASK_QUEUE_NAME, autoAck, deliverCallback, consumerTag -> {
            System.out.println(consumerTag + "消费者取消消费接口回调逻辑");
        });
    }


}
