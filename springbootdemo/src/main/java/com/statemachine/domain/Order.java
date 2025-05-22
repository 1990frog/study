package com.statemachine.domain;

import com.statemachine.config.OrderStates;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private OrderStates state;
}
