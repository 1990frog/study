package com.sourcecode.listener.simulation;

import com.sourcecode.listener.simulation.event.RainEvent;
import com.sourcecode.listener.simulation.listener.RainListener;
import com.sourcecode.listener.simulation.event.SnowEvent;
import com.sourcecode.listener.simulation.listener.SnowListener;
import com.sourcecode.listener.simulation.multicaster.WeatherEventMulticaster;

public class App {

    /**
     * 监听器模式4要素：
     * 事件
     * 监听器
     * 广播器
     * 触发机制
     *
     * @param args
     */
    public static void main(String[] args) {
        WeatherEventMulticaster eventMulticaster = new WeatherEventMulticaster();
        RainListener rainListener = new RainListener();
        SnowListener snowListener = new SnowListener();
        eventMulticaster.addListener(rainListener);
        eventMulticaster.addListener(snowListener);
        eventMulticaster.multicastEvent(new SnowEvent());
        eventMulticaster.multicastEvent(new RainEvent());
        eventMulticaster.removeListener(rainListener);
        eventMulticaster.multicastEvent(new SnowEvent());
        eventMulticaster.multicastEvent(new RainEvent());
    }

}
