package com.customer.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RocketMQTransactionListener(txProducerGroup = "tx-group")
public class StreamRocketMqLocalTransationalListener implements RocketMQLocalTransactionListener {

    /**
     * 执行本地事务，如果执行成功发送COMMIT给MQ完成二次确认，让消息投递，反之，ROLLBACK
     * @param message
     * @param o
     * @return
     */
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        try{
            // 这做个事务
            log.info("执行事务！");
            return RocketMQLocalTransactionState.COMMIT;
        }catch (Exception e){
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        MessageHeaders messageHeaders = message.getHeaders();
        String serialNumber = (String)messageHeaders.get("SerialNumber");
        log.info("通过业务流水号：{}，清除之前操作的数据",serialNumber);
        return RocketMQLocalTransactionState.ROLLBACK;
    }
}
