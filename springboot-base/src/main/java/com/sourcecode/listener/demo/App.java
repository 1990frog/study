package com.sourcecode.listener.demo;


import com.sourcecode.listener.demo.event.PlayEvent;
import com.sourcecode.listener.demo.listener.PlayListener;
import com.sourcecode.listener.demo.listener.WorkListener;
import com.sourcecode.listener.demo.multicaster.Multicaster;

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
