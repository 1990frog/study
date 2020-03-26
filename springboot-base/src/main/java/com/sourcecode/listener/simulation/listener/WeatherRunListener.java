package com.sourcecode.listener.simulation.listener;

import com.sourcecode.listener.simulation.event.RainEvent;
import com.sourcecode.listener.simulation.event.SnowEvent;
import com.sourcecode.listener.simulation.multicaster.WeatherEventMulticaster;
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
