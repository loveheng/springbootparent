package com.zzh.scheduler.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask1 {

    private  int count = 0;

    @Scheduled(cron="*/6 * * * * ?")
    public void proocess() {
        System.out.println("SchedulerTask1:"+(count++));
    }

}
