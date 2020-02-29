package com.source.listener.demo;


import com.source.listener.demo.event.PlayEvent;
import com.source.listener.demo.listener.PlayListener;
import com.source.listener.demo.listener.WorkListener;
import com.source.listener.demo.multicaster.Multicaster;

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
