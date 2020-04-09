package com.listener.simulation.multicaster;

import com.listener.simulation.event.WeatherEvent;
import com.listener.simulation.listener.WeatherListener;

public interface EventMulticaster {

    void multicastEvent(WeatherEvent event);

    void addListener(WeatherListener weatherListener);

    void removeListener(WeatherListener weatherListener);

}
