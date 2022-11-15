package com.urain.rabbitmq.eight;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.urain.rabbitmq.utils.RabbitMQUtils;

/**
 * @ClassName: Producer
 * @Package: com.urain.rabbitmq.eight
 * @Author: urain
 * @Date: 2022/9/25 21:55
 * @Version: 1.0.0
 * @Description: 死信队列生产者代码
 */
public class Producer {

    // 普通交换机名称
    public static final String NORMAL_EXCHANGE = "normal_exchange";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQUtils.getChannel("192.168.15.114", "admin", "123456");
        // 死信消息，设置TTL 单位ms
        // AMQP.BasicProperties properties = new AMQP.BasicProperties().builder().expiration("10000").build();


        for (int i = 1; i < 11; i++) {
            String message = "info" + i;
            channel.basicPublish(NORMAL_EXCHANGE, "zhangsan", null, message.getBytes());

        }

    }


}
