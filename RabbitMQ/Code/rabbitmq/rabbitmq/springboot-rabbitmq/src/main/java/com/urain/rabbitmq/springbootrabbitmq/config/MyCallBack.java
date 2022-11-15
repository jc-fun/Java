package com.urain.rabbitmq.springbootrabbitmq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @ClassName: MyCallBack
 * @Package: com.urain.rabbitmq.springbootrabbitmq.config
 * @Author: urain
 * @Date: 2022/9/29 21:51
 * @Version: 1.0.0
 * @Description: 回调接口
 */
@Component
@Slf4j
public class MyCallBack implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnsCallback {


    @Resource
    private RabbitTemplate rabbitTemplate;

    // 注入
    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnsCallback(this);
    }

    /**
     * 交换机确认回调方法
     * 1.发消息 交换机接收到了 回调
     *  1.1 correlationData 保存回调消息的ID及相关信息
     *  1.2 交换机收到消息 true
     *  1.3 cause null
     * 2.发消息 交换机接收失败了 回调
     *  2.1 correlationData 保存回调消息的ID及相关信息
     *  2.2 交换机收到消息 ack = false
     *  2.3 cause 失败的原因
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        assert correlationData != null;
        String id = correlationData.getId();
        if (ack) {
            log.info("交换机已收到Id为：{}的消息", id);
        } else {
            log.info("交换机还未收到Id为：{}的消息，由于原因：{}", id, cause);
        }

    }

    // 当消息传递过程中不可达目的地时将消息返回给生产者，只有在不可达时才会进行回退
    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {

        log.error("消息：{}，被交换机{}退回，退回原因：{}，路由Key：{}", new String(returnedMessage.getMessage().getBody()),
            returnedMessage.getExchange(), returnedMessage.getReplyText(), returnedMessage.getRoutingKey());

    }
}
