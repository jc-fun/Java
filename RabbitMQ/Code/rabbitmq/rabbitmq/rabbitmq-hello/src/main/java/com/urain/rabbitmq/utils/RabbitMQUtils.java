package com.urain.rabbitmq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: RabbitMQUtils
 * @Package: com.urain.rabbitmq.utils
 * @Author: urain
 * @Date: 2022/9/19 23:06
 * @Version: 1.0.0
 * @Description: 连接工厂创建信道的工具类
 */
public class RabbitMQUtils {

    public static Channel getChannel(String ip, String username, String password) throws IOException,
        TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(ip);
        factory.setUsername(username);
        factory.setPassword(password);
        Connection connection = factory.newConnection();
        return connection.createChannel();
    }


}
