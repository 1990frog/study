package com.component.listener.demo;


import com.component.listener.demo.event.PlayEvent;
import com.component.listener.demo.listener.PlayListener;
import com.component.listener.demo.listener.WorkListener;
import com.component.listener.demo.multicaster.Multicaster;

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
