package com.listener.demo.listener;

import com.listener.demo.event.WeatherEvent;

public interface WeatherListener {

    void onWeatherEvent(WeatherEvent event);

}
