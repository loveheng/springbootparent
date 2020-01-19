package com.zzh.scheduler.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SchedulerTask2 {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        System.out.println("SchedulerTask2.reportCurrentTime"+dateFormat.format(new Date()));
    }
}
