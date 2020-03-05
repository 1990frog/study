package com.listener.simulation.listener;

import com.listener.simulation.event.WeatherEvent;

public interface WeatherListener {

    void onWeatherEvent(WeatherEvent event);

}
