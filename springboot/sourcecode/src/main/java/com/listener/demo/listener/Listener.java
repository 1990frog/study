package com.listener.demo.listener;

import springboot.component.listener.demo.event.Event;

public interface Listener {

    public void action(Event event);

}
