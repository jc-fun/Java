package com.urain.rabbitmq.six;

import com.rabbitmq.client.Channel;
import com.urain.rabbitmq.utils.RabbitMQUtils;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @ClassName: DirectLogs
 * @Package: com.urain.rabbitmq.six
 * @Author: urain
 * @Date: 2022/9/23 23:47
 * @Version: 1.0.0
 * @Description: TODO
 */
public class DirectLogs {

    public static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQUtils.getChannel("192.168.15.114", "admin", "123456");


        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String message = scanner.next();
            channel.basicPublish(EXCHANGE_NAME, "warning", null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("生产者发出消息：" + message);
        }


    }

}
