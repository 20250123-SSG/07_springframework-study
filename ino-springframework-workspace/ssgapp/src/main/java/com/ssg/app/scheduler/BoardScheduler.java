package com.ssg.app.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BoardScheduler {

    @Scheduled(cron = "0/10 * * * * *")
    public void execute1(){
        log.debug("hello world");
    }
}
