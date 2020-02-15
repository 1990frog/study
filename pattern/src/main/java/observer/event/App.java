package observer.event;

public class App {

    public static void main(String[] args) {
        //初始化广播器
        WeatherEventMulticaster eventMulticaster = new WeatherEventMulticaster();
        //初始化监听器
        RainListener rainListener = new RainListener();
        SnowListener snowListener = new SnowListener();
        //广播器添加监听器
        eventMulticaster.addListener(rainListener);
        eventMulticaster.addListener(snowListener);
        //广播器添加事件触发监听器
        eventMulticaster.multicastEvent(new SnowEvent());
        eventMulticaster.multicastEvent(new RainEvent());
//        eventMulticaster.removeListener(rainListener);
//        eventMulticaster.multicastEvent(new SnowEvent());
//        eventMulticaster.multicastEvent(new RainEvent());
    }

}
