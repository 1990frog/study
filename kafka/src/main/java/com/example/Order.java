package com.example;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private Long id;
    private String name;
    private LocalDateTime orderDate;
}
