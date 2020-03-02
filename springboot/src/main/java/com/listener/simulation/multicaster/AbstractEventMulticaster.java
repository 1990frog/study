package com.listener.simulation.multicaster;

import com.listener.simulation.event.WeatherEvent;
import com.listener.simulation.listener.WeatherListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class AbstractEventMulticaster implements EventMulticaster {

    @Autowired
    private List<WeatherListener> listenerList;

    @Override
    public void multicastEvent(WeatherEvent event) {
        doStart();
        listenerList.forEach(i -> i.onWeatherEvent(event));
        doEnd();
    }

    @Override
    public void addListener(WeatherListener weatherListener) {
        listenerList.add(weatherListener);
    }

    @Override
    public void removeListener(WeatherListener weatherListener) {
        listenerList.remove(weatherListener);
    }

    abstract void doStart();

    abstract void doEnd();

}
