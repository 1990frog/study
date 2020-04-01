package springboot.component.listener;

import org.springframework.context.ApplicationEvent;

public class DiySpringBootEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public DiySpringBootEvent(Object source) {
        super(source);
    }
}
