package old.event;

public interface EventMulticaster {

    void multicastEvent(WeatherEvent event);

    void addListener(WeatherListener weatherListener);

    void removeListener(WeatherListener weatherListener);

}
