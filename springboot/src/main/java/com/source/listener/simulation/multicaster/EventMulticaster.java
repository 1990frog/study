package com.source.listener.simulation.multicaster;

import com.source.listener.simulation.event.WeatherEvent;
import com.source.listener.simulation.listener.WeatherListener;

public interface EventMulticaster {

    void multicastEvent(WeatherEvent event);

    void addListener(WeatherListener weatherListener);

    void removeListener(WeatherListener weatherListener);

}
