package com.source.listener.demo.listener;

import com.source.listener.demo.event.Event;
import com.source.listener.demo.event.WorkEvent;

public class WorkListener implements Listener {
    @Override
    public void action(Event event) {
        if(event instanceof WorkEvent)
            System.out.println("this is work listener");
    }
}
