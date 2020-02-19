package com.listener.demo.event;

public class SnowEvent extends WeatherEvent {
    @Override
    public String getWeather() {
        return "snow";
    }
}
