package com.customer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.UUID;

@Slf4j
@Controller
public class SpringcloudStreamController {

    @Autowired
    private Source source;
    @Autowired
    private MySource mySource;

    @GetMapping("/stream/default")
    public String defaultOuput() {
        this.source.output().send(MessageBuilder.withPayload("hello").build());
        return "";
    }

    @PutMapping("/stream/output1")
    public String output1() {
        this.mySource.output1().send(MessageBuilder.withPayload("output1" + UUID.randomUUID()).build());
        return "";
    }

    @PutMapping("/stream/output2")
    public String output2() {
        this.mySource.output2().send(MessageBuilder.withPayload("output2" + UUID.randomUUID()).build());
        return "";
    }

    @PutMapping("/stream/output3")
    public String output3() {
        this.mySource.output3().send(MessageBuilder.withPayload("output3" + UUID.randomUUID()).build());
        return "";
    }

    @StreamListener(Sink.INPUT)
    public void defaultInput(String messageBody){
        log.info("通过stream收到了消息： messageBody= {} ", messageBody);
    }

    @StreamListener(MySink.INPUT1)
    public void input1(String messageBody){
        log.info("input1收到了消息： messageBody= {} ", messageBody);
    }

    @StreamListener(MySink.INPUT2)
    public void input2(String messageBody){
        log.info("input2收到了消息： messageBody= {} ", messageBody);
//        throw new RuntimeException("error");
    }

    @StreamListener(MySink.INPUT3)
    public void input3(String messageBody) {
        log.info("input3收到了消息： messageBody= {} ", messageBody);
//        throw new RuntimeException("error");
    }

    /**
     * 主题3专用的异常监控
     * @param message
     */
    @ServiceActivator(inputChannel = "topic3.group3.errors")
    public void handleError(ErrorMessage message) {
        Throwable throwable = message.getPayload();
        log.error("截获异常", throwable);

        Message<?> originalMessage = message.getOriginalMessage();
        assert originalMessage != null;

        log.info("原始消息体 = {}", new String((byte[]) originalMessage.getPayload()));
    }

    /**
     * 通过轮询方式发送消息
     * @return
     */
//    @Bean
//    @InboundChannelAdapter(value = MySource.OUTPUT3, poller = @Poller(fixedDelay = "1000", maxMessagesPerPoll = "1"))
//    public MessageSource<String> test() {
//        return () -> new GenericMessage<>("error");
//    }

    /**
     * 全局的消息异常监控
     * @param message
     */
    @StreamListener("errorChannel")
    public void error(Message<?> message) {
        ErrorMessage errorMessage = (ErrorMessage) message;
        log.error("消息全局异常触发 = {}",errorMessage);
    }

}
