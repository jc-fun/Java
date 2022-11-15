package com.urain.rabbitmq.springbootrabbitmq.controller;

import com.urain.rabbitmq.springbootrabbitmq.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: ProducerController
 * @Package: com.urain.rabbitmq.springbootrabbitmq.controller
 * @Author: urain
 * @Date: 2022/9/29 21:35
 * @Version: 1.0.0
 * @Description: 开始发消息  测试确认
 */
@RestController
@RequestMapping("/confirm")
@Slf4j
public class ProducerController {

    @Resource
    private RabbitTemplate rabbitTemplate;

    // 发消息
    @GetMapping("/sendMessage/{message}")
    public void sendMessage(@PathVariable String message) {
        CorrelationData correlationDat1 = new CorrelationData("1");
        rabbitTemplate.convertAndSend(ConfirmConfig.CONFIRM_EXCHANGE_NAME,
            ConfirmConfig.CONFIRM_ROUTING_KEY, message + " key1", correlationDat1);
        log.info("发送消息内容为：{}", message + " key1");


        CorrelationData correlationData2 = new CorrelationData("2");
        rabbitTemplate.convertAndSend(ConfirmConfig.CONFIRM_EXCHANGE_NAME,
            ConfirmConfig.CONFIRM_ROUTING_KEY + " 2", message + " key2", correlationData2);
        log.info("发送消息内容为：{}", message + " key2");

    }


}
