package com.example;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.statemachine.config.OrderEvents;
import com.statemachine.config.OrderStates;
import com.statemachine.domain.Order;
import com.statemachine.service.OrderProcessor;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class StateMachineApplicationTests {

    @Resource
    private OrderProcessor orderProcessor;

    @Test
    public void pay() throws Exception{
        Order order = new Order(OrderStates.UNPAID);
        orderProcessor.process(order, OrderEvents.PAY);
    }
    
}
