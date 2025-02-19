package learn_thread.old;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PropertiesDemo {

    public static void main(String[] args) {
        log.info("线程名称：{}", Thread.currentThread().getName());
        log.info("线程组：{}", Thread.currentThread().getThreadGroup().getName());
        log.info("优先级：{}", Thread.currentThread().getPriority());
        log.info("线程状态：{}", Thread.currentThread().getState());
    }
}
