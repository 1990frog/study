package com.component.listener.demo.multicaster;

import com.component.listener.demo.event.Event;
import com.component.listener.demo.listener.Listener;

import java.util.ArrayList;
import java.util.List;

public class Multicaster {

    private List<Listener> listenerList;

    public Multicaster(){
        listenerList = new ArrayList<>();
    }

    public void addLisener(Listener listener){
        this.listenerList.add(listener);
    }

    public void happen(Event event){
        listenerList.forEach(listener -> listener.action(event));
    }

}
