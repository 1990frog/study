package com.source.listener.simulation.listener;

import com.source.listener.simulation.event.RainEvent;
import com.source.listener.simulation.event.WeatherEvent;
import org.springframework.stereotype.Component;

@Component
public class RainListener implements WeatherListener {
    @Override
    public void onWeatherEvent(WeatherEvent event) {
        if (event instanceof RainEvent) {
            System.out.println("hello " + event.getWeather());
        }
    }
}
