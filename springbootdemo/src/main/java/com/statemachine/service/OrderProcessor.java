package com.statemachine.service;

import javax.annotation.Resource;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;

import com.statemachine.config.OrderEvents;
import com.statemachine.config.OrderStates;
import com.statemachine.domain.Order;

public class OrderProcessor {

    @Resource
    private StateMachine<OrderStates, OrderEvents> orderStateMachine;

    @Resource
    private StateMachinePersister<OrderStates, OrderEvents, Order> persister;

    public Boolean process(Order order, OrderEvents event) throws Exception {
        Message<OrderEvents> message = MessageBuilder.withPayload(event)
                .setHeader("order", order)
                .build();
        boolean b = sendEvent(message);
        return b;
    }

    private boolean sendEvent(Message<OrderEvents> message) throws Exception {
        Order order = (Order) message.getHeaders().get("order");
        persister.restore(orderStateMachine, order);
        boolean result = orderStateMachine.sendEvent(message);
        return result;
    }


}
