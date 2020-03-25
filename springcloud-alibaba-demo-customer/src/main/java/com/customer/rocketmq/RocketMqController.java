package com.customer.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Slf4j
@Controller
public class RocketMqController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("rocketmq/send")
    @ResponseBody
    public String send() {
        rocketMQTemplate.convertAndSend("topic","this is a rocketmq message!");
        return "";
    }

    @PutMapping("rocketmq/tx1")
    public String transactionMessage(){
        rocketMQTemplate.sendMessageInTransaction(
                "tx-group2",
                "topic",
                MessageBuilder.withPayload("transaction")
                        .setHeader(RocketMQHeaders.TRANSACTION_ID, UUID.randomUUID())
                        .build(),
                "test"
        );
        System.out.println("haha");
        return "success";
    }

    TransactionMQProducer transactionMQProducer;

    @PostConstruct
    public void init() throws MQClientException {
        transactionMQProducer = new TransactionMQProducer("tx-group2");
        transactionMQProducer.setNamesrvAddr("localhost:9876");
        transactionMQProducer.start();
        transactionMQProducer.setTransactionListener(new TransactionListener() {
            @Override
            public LocalTransactionState executeLocalTransaction(Message message, Object o) {
                return LocalTransactionState.COMMIT_MESSAGE;
            }

            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        });
    }

    @PutMapping("rocketmq/tx2")
    public void tx() throws MQClientException {
        transactionMQProducer.sendMessageInTransaction(new Message("topic2","transation2".getBytes()),"001");
    }

}
