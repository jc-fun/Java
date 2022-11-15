package com.urain.rabbitmq.four;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;
import com.urain.rabbitmq.utils.RabbitMQUtils;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: ConfirmMessage
 * @Package: com.urain.rabbitmq.four
 * @Author: urain
 * @Date: 2022/9/22 22:54
 * @Version: 1.0.0
 * @Description: 发布确认模式
 * 1.单个确认
 * 2.批量确认
 * 3.异步批量确认
 */
public class ConfirmMessage {

    /**
     * 批量发消息的个数
     */
    public static final int MESSAGE_COUNT = 1000;

    public static void main(String[] args) throws Exception {
        // 1.单个确认
        // ConfirmMessage.publishMessageIndividually(); // 500ms
        // 2.批量确认
        // ConfirmMessage.publishMessageBatch(); //109ms
        // 3.异步批量确认
        ConfirmMessage.publishMessageAsync(); // 87ms

    }

    /**
     * 单个发布确认
     */
    public static void publishMessageIndividually() throws IOException, TimeoutException,
        InterruptedException {
        Channel channel = RabbitMQUtils.getChannel("192.168.15.114", "admin", "123456");
        // 队列的声明
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, false, false, false, null);
        // 开启发布确认
        channel.confirmSelect();
        // 开始时间
        long begin = System.currentTimeMillis();

        // 批量发消息
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String message = String.valueOf(i);
            channel.basicPublish("", queueName, null, message.getBytes());
            // 单个确认
            boolean flag = channel.waitForConfirms();
            if (flag) {
                System.out.println("消息发送成功");
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("发布" + MESSAGE_COUNT + "个单独确认消息，耗时" + (end - begin) + "ms");

    }

    /**
     * 批量发布确认
     */
    public static void publishMessageBatch() throws Exception {

        Channel channel = RabbitMQUtils.getChannel("192.168.15.114", "admin", "123456");
        // 队列的声明
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, false, false, false, null);
        // 开启发布确认
        channel.confirmSelect();
        // 开始时间
        long begin = System.currentTimeMillis();
        // 批量确认消息大小
        int batchSize = 1000;

        // 批量发送消息 批量发布确认
        for (int i = 1; i <= MESSAGE_COUNT; i++) {
            String message = String.valueOf(i);
            channel.basicPublish("", queueName, null, message.getBytes());
            // 批量确认
            if (i % batchSize == 0) {
                channel.waitForConfirms();
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("发布" + MESSAGE_COUNT + "个批量确认消息，耗时" + (end - begin) + "ms");

    }


    /**
     * 异步发布确认
     */
    public static void publishMessageAsync() throws Exception {

        Channel channel = RabbitMQUtils.getChannel("192.168.15.114", "admin", "123456");
        // 队列的声明
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, false, false, false, null);
        // 开启发布确认
        channel.confirmSelect();
        /**
         * 线程安全有序的哈希表，适用于高并发的情况下
         * 1.轻松的将序号与消息进行关联
         * 2.轻松的批量删除条目，只要给到序号
         * 3.支持高并发（多线程）
         */
        ConcurrentSkipListMap<Long, String> outstandingConfirms = new ConcurrentSkipListMap<>();


        // 准备消息监听器 监听哪些消息成功，哪些失败
        /**
         * 1.消息的标记
         * 2.是否为批量确认
         */
        // 消息确认成功回调
        ConfirmCallback ackCallback = (deliveryTag, multiple) -> {
            if (multiple) {
                // 2.删除已经确认的消息 剩下未确认的消息
                ConcurrentNavigableMap<Long, String> confirmed =
                    outstandingConfirms.headMap(deliveryTag);
                confirmed.clear();
            } else {
                outstandingConfirms.remove(deliveryTag);
            }
            System.out.println("确认的消息" + deliveryTag);
        };
        // 消息确认失败回调
        ConfirmCallback nackCallback = (deliveryTag, multiple) -> {
            // 3.打印一下为确认的消息
            String message = outstandingConfirms.get(deliveryTag);
            System.out.println("未确认的消息：" + message + ":::" + "未确认消息的tag：" + deliveryTag);

        };

        // 异步通知
        channel.addConfirmListener(ackCallback, nackCallback);

        // 开始时间
        long begin = System.currentTimeMillis();
        // 批量发送
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String message = "消息" + i;
            // 1.此处记录下所有发送的消息
            outstandingConfirms.put(channel.getNextPublishSeqNo(), message);
            channel.basicPublish("", queueName, null, message.getBytes());
        }

        long end = System.currentTimeMillis();
        System.out.println("发布" + MESSAGE_COUNT + "个异步确认消息，耗时" + (end - begin) + "ms");

    }

}
