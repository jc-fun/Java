package com.urain.rabbitmq.five;

import com.rabbitmq.client.Channel;
import com.urain.rabbitmq.utils.RabbitMQUtils;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @ClassName: EmitLog
 * @Package: com.urain.rabbitmq.five
 * @Author: urain
 * @Date: 2022/9/23 22:39
 * @Version: 1.0.0
 * @Description: 发消息 交换机
 */
public class EmitLog {

    // 交换机的名称
    public static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQUtils.getChannel("192.168.15.114", "admin", "123456");
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String message = scanner.next();
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("生产者发出消息：" + message);
        }


    }


}
