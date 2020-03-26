package com.sourcecode.listener.simulation.listener;

import com.sourcecode.listener.simulation.event.SnowEvent;
import com.sourcecode.listener.simulation.event.WeatherEvent;
import org.springframework.stereotype.Component;

@Component
public class SnowListener implements WeatherListener {
    @Override
    public void onWeatherEvent(WeatherEvent event) {
        if (event instanceof SnowEvent) {
            System.out.println("hello " + event.getWeather());
        }
    }
}
