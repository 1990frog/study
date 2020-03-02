package com.entity;

import org.springframework.stereotype.Component;

@Component("demo")
public class DemoEntity {
    private int id = 1;
    public void print(){
        System.out.println("DemoEntry is new and id is "+id);
    }
}
