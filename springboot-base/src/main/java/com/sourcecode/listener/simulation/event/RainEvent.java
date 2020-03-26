package com.sourcecode.listener.simulation.event;

public class RainEvent extends WeatherEvent {
    @Override
    public String getWeather() {
        return "rain";
    }
}
