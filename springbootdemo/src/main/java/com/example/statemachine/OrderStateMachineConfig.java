package com.example.statemachine;

import java.util.EnumSet;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

@Configuration
@EnableStateMachine
public class OrderStateMachineConfig extends EnumStateMachineConfigurerAdapter<OrderStates, OrderEvents> {

    @Override
    public void configure(StateMachineStateConfigurer<OrderStates, OrderEvents> states) 
        throws Exception {
        states
            .withStates()
            .initial(OrderStates.UNPAID)
            .states(EnumSet.allOf(OrderStates.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStates, OrderEvents> transitions) 
        throws Exception {
        transitions
            .withExternal()
                .source(OrderStates.UNPAID).target(OrderStates.WAITING_FOR_RECEIVE)
                .event(OrderEvents.PAY)
            .and()
            .withExternal()
                .source(OrderStates.WAITING_FOR_RECEIVE).target(OrderStates.DONE)
                .event(OrderEvents.RECEIVE);
    }
}
