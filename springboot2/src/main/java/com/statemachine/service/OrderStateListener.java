package com.statemachine.service;

import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.stereotype.Component;

import com.statemachine.config.OrderEvents;
import com.statemachine.config.OrderStates;
import com.statemachine.domain.Order;

import lombok.extern.slf4j.Slf4j;

@Component("orderStateListener")
@Slf4j
public class OrderStateListener {
    
    @OnTransition(source = "UNPAID", target = "WAITING_FOR_RECEIVE")
    public boolean pay(Message<OrderEvents> message) {
        Order order = (Order) message.getHeaders().get("order");
        order.setState(OrderStates.WAITING_FOR_RECEIVE);
        log.info("订单支付成功，当前状态：{}", order.getState());
        return true;
    }

}
