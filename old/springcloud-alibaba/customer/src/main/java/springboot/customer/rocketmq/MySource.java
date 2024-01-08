package springboot.customer.rocketmq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 可能会造成mybatis异常，关闭或者排除mybatis扫描此类
 * 我可以定义多个output监听不同的topic，topic要在yml中配置
 * 也可以将output与input定义到一个接口中，用注解区分
 */
public interface MySource {

    String OUTPUT1 = "output1";
    String OUTPUT2 = "output2";
    String OUTPUT3 = "output3";

    @Output(OUTPUT1)
    MessageChannel output1();

    @Output(OUTPUT2)
    MessageChannel output2();

    @Output(OUTPUT3)
    MessageChannel output3();
}
