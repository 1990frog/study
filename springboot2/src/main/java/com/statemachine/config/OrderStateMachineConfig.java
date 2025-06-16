package com.statemachine.config;

import java.util.EnumSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.support.DefaultStateMachineContext;

import com.statemachine.domain.Order;

@Configuration
@EnableStateMachine(name = "orderStateMachine")
public class OrderStateMachineConfig extends EnumStateMachineConfigurerAdapter<OrderStates, OrderEvents> {

    /**
     * 这个方法是用来配置状态机的状态的
     * @param states
     * @throws Exception
     */
    @Override
    public void configure(StateMachineStateConfigurer<OrderStates, OrderEvents> states) 
        throws Exception {
        states
            .withStates()
            // 初始化状态
            .initial(OrderStates.UNPAID)
            .states(EnumSet.allOf(OrderStates.class));
    }

    /** 
     * 这个方法是用来配置状态机的转换的
     * @param transitions
     * @throws Exception
     */
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

    /**
     * 这个方法是用来配置状态机的持久化的
     * @return
     */
    @Bean
    public DefaultStateMachinePersister<Object, Object, Order> persister() {
        return new DefaultStateMachinePersister<>(new StateMachinePersist<Object, Object, Order>(){
            @Override
            public void write(StateMachineContext<Object, Object> context, Order order) throws Exception {
                System.out.println("write");
            }

            @Override
            public StateMachineContext<Object,Object> read(Order order) throws Exception {
                System.out.println("read");
                return new DefaultStateMachineContext(order.getState(), null, null, null);
            }
        });
    }
}
