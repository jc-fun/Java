package com.urain.rabbitmq.six;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.urain.rabbitmq.utils.RabbitMQUtils;

import java.nio.charset.StandardCharsets;

/**
 * @ClassName: ReceiveLogsDirect01
 * @Package: com.urain.rabbitmq.six
 * @Author: urain
 * @Date: 2022/9/23 23:40
 * @Version: 1.0.0
 * @Description: TODO
 */
public class ReceiveLogsDirect01 {

    public static final String EXCHANGE_NAME =  "direct_logs";

    public static void main(String[] args) throws Exception {

        Channel channel = RabbitMQUtils.getChannel("192.168.15.114", "admin", "123456");
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        channel.queueDeclare("console", false, false, false, null);
        channel.queueBind("console", EXCHANGE_NAME, "info");
        channel.queueBind("console", EXCHANGE_NAME, "warning");
        // 接收消息
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("ReceiveLogsDirect01控制台打印接收到的消息：" + new String(message.getBody(),
                StandardCharsets.UTF_8));

        };

        channel.basicConsume("console", true, deliverCallback, consumerTag -> {});
    }

}
