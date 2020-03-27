package com.action.timetask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
public class Schedule {

    @Scheduled(fixedRate = 2000)
    public void task(){
        log.info("schedule");
    }
}
