package springboot.component.listener.simulation.listener;

import springboot.component.listener.simulation.event.RainEvent;
import springboot.component.listener.simulation.event.SnowEvent;
import springboot.component.listener.simulation.multicaster.WeatherEventMulticaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherRunListener {

    @Autowired
    private WeatherEventMulticaster eventMulticaster;

    public void snow() {
        eventMulticaster.multicastEvent(new SnowEvent());
    }

    public void rain() {
        eventMulticaster.multicastEvent(new RainEvent());
    }

}
