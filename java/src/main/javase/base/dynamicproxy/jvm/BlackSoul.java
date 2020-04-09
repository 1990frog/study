package com.dynamicproxy.jvm;

/**
 * 被代理类
 */
public class BlackSoul implements Game {
    @Override
    public void pay() {
        System.out.println("$60");
    }

    @Override
    public void play() {
        System.out.println("dead dead dead");
    }
}
