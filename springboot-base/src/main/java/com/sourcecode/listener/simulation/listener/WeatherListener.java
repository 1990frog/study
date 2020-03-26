package com.sourcecode.listener.simulation.listener;

import com.sourcecode.listener.simulation.event.WeatherEvent;

public interface WeatherListener {

    void onWeatherEvent(WeatherEvent event);

}
