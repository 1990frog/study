package com.listener.demo;


import com.listener.demo.event.PlayEvent;
import com.listener.demo.listener.PlayListener;
import com.listener.demo.listener.WorkListener;
import com.listener.demo.multicaster.Multicaster;

public class App {

    public void test(){
        Multicaster multicaster = new Multicaster();
        multicaster.addLisener(new PlayListener());
        multicaster.addLisener(new WorkListener());
        multicaster.happen(new PlayEvent());
    }

    public static void main(String[] args) {
        new App().test();
    }
}
