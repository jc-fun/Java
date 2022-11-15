package com.urain.rabbitmq.springbootrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DelayedQueueConfig
 * @Package: com.urain.rabbitmq.springbootrabbitmq.config
 * @Author: urain
 * @Date: 2022/9/29 20:19
 * @Version: 1.0.0
 * @Description: TODO
 */
@Configuration
public class DelayedQueueConfig {
    // 队列
    public static final String DELAYED_QUEUE_NAME = "delayed.queue";
    // 交换机
    public static final String DELAYED_EXCHANGE_NAME = "delayed.exchange";

    // routingKey
    public static final String DELAYED_ROUTING_KEY = "delayed.routingkey";

    // 声明交换机  基于插件
    @Bean
    public CustomExchange delayedExchange() {
        /**
         * 1.交换机的名称
         * 2.交换机的类型
         * 3.是否需要持久化
         * 4.是否需要自动删除
         * 5.其它参数
         */
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-delayed-type", "direct");
        return new CustomExchange(DELAYED_EXCHANGE_NAME, "x-delayed-message", true, false, arguments);
    }

    @Bean
    public Queue delayedQueue() {
        return new Queue(DELAYED_QUEUE_NAME);
    }

    // 绑定
    @Bean
    public Binding delayedQueueBindingDelayedExchange(@Qualifier("delayedQueue") Queue delayedQueue,
                                                      @Qualifier("delayedExchange") CustomExchange delayedEcExchange) {
        return BindingBuilder.bind(delayedQueue).to(delayedEcExchange).with(DELAYED_ROUTING_KEY).noargs();
    }

}
