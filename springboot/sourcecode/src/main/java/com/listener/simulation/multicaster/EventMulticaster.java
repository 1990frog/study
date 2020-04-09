package com.listener.simulation.multicaster;

import springboot.component.listener.simulation.event.WeatherEvent;
import springboot.component.listener.simulation.listener.WeatherListener;

public interface EventMulticaster {

    void multicastEvent(WeatherEvent event);

    void addListener(WeatherListener weatherListener);

    void removeListener(WeatherListener weatherListener);

}
