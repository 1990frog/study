package com.source.listener.simulation.listener;

import com.source.listener.simulation.event.WeatherEvent;

public interface WeatherListener {

    void onWeatherEvent(WeatherEvent event);

}
