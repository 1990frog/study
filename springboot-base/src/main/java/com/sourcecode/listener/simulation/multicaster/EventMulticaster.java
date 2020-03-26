package com.sourcecode.listener.simulation.multicaster;

import com.sourcecode.listener.simulation.event.WeatherEvent;
import com.sourcecode.listener.simulation.listener.WeatherListener;

public interface EventMulticaster {

    void multicastEvent(WeatherEvent event);

    void addListener(WeatherListener weatherListener);

    void removeListener(WeatherListener weatherListener);

}
