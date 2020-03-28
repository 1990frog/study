package com.component.listener.simulation.multicaster;

import com.component.listener.simulation.event.WeatherEvent;
import com.component.listener.simulation.listener.WeatherListener;

public interface EventMulticaster {

    void multicastEvent(WeatherEvent event);

    void addListener(WeatherListener weatherListener);

    void removeListener(WeatherListener weatherListener);

}
