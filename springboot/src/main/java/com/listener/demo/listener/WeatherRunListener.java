package com.listener.demo.listener;

import com.listener.demo.event.RainEvent;
import com.listener.demo.event.SnowEvent;
import com.listener.demo.multicaster.WeatherEventMulticaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherRunListener {

    @Autowired
    private WeatherEventMulticaster eventMulticaster;

    public void snow() {
        eventMulticaster.multicastEvent(new SnowEvent());
    }

    public void rain() {
        eventMulticaster.multicastEvent(new RainEvent());
    }

}
