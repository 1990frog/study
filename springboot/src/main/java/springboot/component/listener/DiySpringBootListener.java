package springboot.component.listener;

import org.springframework.context.ApplicationListener;

public class DiySpringBootListener implements ApplicationListener<DiySpringBootEvent> {
    @Override
    public void onApplicationEvent(DiySpringBootEvent event) {
        System.out.println("this is my event");
    }
}
