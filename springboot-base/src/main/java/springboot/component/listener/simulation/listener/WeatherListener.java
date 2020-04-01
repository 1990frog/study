package springboot.component.listener.simulation.listener;

import springboot.component.listener.simulation.event.WeatherEvent;

public interface WeatherListener {

    void onWeatherEvent(WeatherEvent event);

}
