package com.statemachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.statemachine.config.OrderEvents;
import com.statemachine.config.OrderStates;


@RestController
public class StateMachineController {

    @Autowired
    private StateMachine<OrderStates, OrderEvents> stateMachine;

    @GetMapping("/pay")
    public String payOrder() {
        stateMachine.sendEvent(OrderEvents.PAY);
        return "当前状态：" + stateMachine.getState().getId();
    }

    @GetMapping("/receive")
    public String receiveOrder() {
        stateMachine.sendEvent(OrderEvents.RECEIVE);
        return "当前状态：" + stateMachine.getState().getId();
    }


}
