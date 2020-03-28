package com.component.listener.demo.listener;

import com.component.listener.demo.event.Event;
import com.component.listener.demo.event.PlayEvent;

public class PlayListener implements Listener {
    @Override
    public void action(Event event) {
        if(event instanceof PlayEvent)
            System.out.println("this is play listener");
    }
}
