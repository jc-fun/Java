package com.urain.rabbitmq.springbootrabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: ConfirmConfig
 * @Package: com.urain.rabbitmq.springbootrabbitmq.config
 * @Author: urain
 * @Date: 2022/9/29 21:18
 * @Version: 1.0.0
 * @Description: 配置类 发布确认高级内容
 */
@Configuration
public class ConfirmConfig {


    // 交换机
    public static final String CONFIRM_EXCHANGE_NAME = "config_exchange";

    // 队列
    public static final String CONFIRM_QUEUE_NAME = "confirmJ_queue";

    // RoutingKey
    public static final String CONFIRM_ROUTING_KEY = "key1";

    // 备份交换机
    public static final String BACKUP_EXCHANGE_NAME = "backup_exchange";

    // 备份队列
    public static final String BACKUP_QUEUE_NAME = "backup_queue";

    // 报警队列
    public static final String WARNING_QUEUE_NAME = "warning_queue";


    // 声明交换机
    @Bean
    public DirectExchange confirmExchange() {
        return ExchangeBuilder.directExchange(CONFIRM_EXCHANGE_NAME).durable(true).withArgument("alternate" +
            "-exchange", BACKUP_EXCHANGE_NAME).build();
    }

    // 声明队列
    @Bean
    public Queue confirmQueue() {
        return QueueBuilder.durable(CONFIRM_QUEUE_NAME).build();
    }

    // 绑定
    @Bean
    public Binding queueBindingExchange(@Qualifier("confirmQueue") Queue confirmQueue,
                                        @Qualifier("confirmExchange") DirectExchange confirmExchange) {
        return BindingBuilder.bind(confirmQueue).to(confirmExchange).with(CONFIRM_ROUTING_KEY);
    }

    // 备份交换机
    @Bean
    public FanoutExchange backupExchange() {
        return new FanoutExchange(BACKUP_EXCHANGE_NAME);
    }

    // 备份队列
    @Bean
    public Queue backupQueue() {
        return QueueBuilder.durable(BACKUP_QUEUE_NAME).build();
    }

    // 报警队列
    @Bean
    public Queue warningQueue() {
        return QueueBuilder.durable(WARNING_QUEUE_NAME).build();
    }

    // 绑定
    @Bean
    public Binding backupQueueBindingBackupExchange(@Qualifier("backupQueue") Queue backupQueue,
                                                    @Qualifier("backupExchange") FanoutExchange backupExchange) {
        return BindingBuilder.bind(backupQueue).to(backupExchange);
    }

    @Bean
    public Binding warningQueueBindingBackupExchange(@Qualifier("warningQueue") Queue warningQueue,
                                                     @Qualifier("backupExchange") FanoutExchange backupExchange) {
        return BindingBuilder.bind(warningQueue).to(backupExchange);
    }
}
