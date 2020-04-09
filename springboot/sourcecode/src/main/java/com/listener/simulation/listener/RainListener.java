package com.listener.simulation.listener;

import springboot.component.listener.simulation.event.RainEvent;
import springboot.component.listener.simulation.event.WeatherEvent;
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
