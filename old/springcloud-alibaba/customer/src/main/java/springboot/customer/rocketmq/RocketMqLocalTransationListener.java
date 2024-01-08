package springboot.customer.rocketmq;

import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

/**
 * 这个注解里面是个线程池哦
 * 如果全部都是默认的化，那性能就呵呵了
 */
@RocketMQTransactionListener(txProducerGroup = "test",corePoolSize = 20, maximumPoolSize = 100)
public class RocketMqLocalTransationListener implements RocketMQLocalTransactionListener {

    /**
     * 执行本地事务的接口
     * @param message 注：Stream只能用header
     * @param o 我的业务流水
     * @return
     */
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        Integer flag = (Integer)o;
        /**
         * 这里加@Transactional太白痴
         * 直接通过注入调一个事务方法就好了
         */
        if(flag==1){
            return RocketMQLocalTransactionState.COMMIT;
        }else{
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }

    /**
     * 检查本地事务是否执行成功
     * @param message
     * @return
     */
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        MessageHeaders messageHeaders = message.getHeaders();
        String transactionalId = (String) messageHeaders.get("transactionalId");
        // 执行回滚
        return RocketMQLocalTransactionState.ROLLBACK;
    }
}
