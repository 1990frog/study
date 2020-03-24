package com.customer.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Slf4j
@Controller
public class RocketMqController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    @Autowired
    private Source source;
    @Autowired
    private MySource mySource;

    @GetMapping("rocketmq/customer")
    @ResponseBody
    public String test() {
        rocketMQTemplate.convertAndSend("topic","haha");
        return "";
    }

    @PutMapping("rocketmq/customer/transaction")
    public String transactionMessage(){
        rocketMQTemplate.sendMessageInTransaction(
                "test",
                "topic",
                MessageBuilder.withPayload("transaction")
                        .setHeader(RocketMQHeaders.TRANSACTION_ID, UUID.randomUUID())
                        .build(),
                "test"
        );
        System.out.println("haha");
        return "success";
    }

    @GetMapping("/test-stream")
    public String testStream(){
        this.source.output().send(MessageBuilder.withPayload("hello").build());
        return "";
    }

    @GetMapping("/test-stream2")
    public String testStream2(){
        this.mySource.output().send(MessageBuilder.withPayload("hello").build());
        return "";
    }

    @StreamListener(Sink.INPUT)
    public void receive(String messageBody){
        log.info("通过stream收到了消息： messageBody= {} "+ messageBody);
    }

    @StreamListener(MySink.MY_INPUT)
    public void receive2(String messageBody){
        log.info("通过stream收到了消息： messageBody= {} "+ messageBody);
    }

}
