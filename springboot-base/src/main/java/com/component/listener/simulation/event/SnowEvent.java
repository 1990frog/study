package com.component.listener.simulation.event;

public class SnowEvent extends WeatherEvent {
    @Override
    public String getWeather() {
        return "snow";
    }
}