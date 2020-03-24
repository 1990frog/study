package com.customer.controller;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 可能会造成mybatis异常，关闭或者排除mybatis扫描此类
 */
public interface MySource {
    String MY_OUTPUT = "my-output";

    @Output(MY_OUTPUT)
    MessageChannel output();
}
