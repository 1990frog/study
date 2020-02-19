package com.listener.demo.multicaster;

import com.listener.demo.event.WeatherEvent;
import com.listener.demo.listener.WeatherListener;

public interface EventMulticaster {

    void multicastEvent(WeatherEvent event);

    void addListener(WeatherListener weatherListener);

    void removeListener(WeatherListener weatherListener);

}
