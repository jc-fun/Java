package com.urain.rabbitmq.springbootrabbitmq.controller;

import com.urain.rabbitmq.springbootrabbitmq.config.DelayedQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName: SendMsgController
 * @Package: com.urain.rabbitmq.springbootrabbitmq.controller
 * @Author: urain
 * @Date: 2022/9/26 22:09
 * @Version: 1.0.0
 * @Description: 发送延迟消息
 */
@RestController
@RequestMapping("/ttl")
@Slf4j
public class SendMsgController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    // 开始发消息
    @GetMapping("/sendMsg/{message}")
    public void sendMsg(@PathVariable String message) {
        log.info("当前时间：{}, 发送一条信息给两个TTL队列：{}", new Date(), message);
        rabbitTemplate.convertAndSend("X", "XA", "消息来自ttl为10s的队列：" + message);
        rabbitTemplate.convertAndSend("X", "XB", "消息来自ttl为40s的队列：" + message);
    }

    // 开始发消息 TTL
    @GetMapping("sendExpirationMsg/{message}/{ttl}")
    public void sendMsg(@PathVariable String message, @PathVariable String ttl) {

        log.info("当前时间：{}, 发送一条时长为{}毫秒的TTL信息给队列QC：{}", new Date(), ttl,  message);
        rabbitTemplate.convertAndSend("X", "XC", message, msg -> {
            // 发送消息时的延迟时长
            msg.getMessageProperties().setExpiration(ttl);
            return msg;
        });


    }

    // 开始发送消息 基于插件的消息及延迟的时间
    @GetMapping("sendDelayMsg/{message}/{delayTime}")
    public void sendMsg(@PathVariable String message, @PathVariable Integer delayTime) {
        log.info("当前时间：{}, 发送一条时长为{}毫秒的信息给队列delayed.queue：{}", new Date(), delayTime,  message);
        rabbitTemplate.convertAndSend(DelayedQueueConfig.DELAYED_EXCHANGE_NAME, DelayedQueueConfig.DELAYED_ROUTING_KEY,
            message, msg -> {
            // 发送消息时的延迟时长 单位ms
            msg.getMessageProperties().setDelay(delayTime);
            return msg;
        });
    }


}
