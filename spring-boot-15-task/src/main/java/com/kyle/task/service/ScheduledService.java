package com.kyle.task.service;

import org.springframework.stereotype.Service;

/**
 * @author: Kyle
 * @date: 2019/10/4 -  10:54
 */
@Service
public class ScheduledService {

    /**
     * @Scheduled该注解表示的是任务定时
     * (cron = "0 * * * * MON-FRI") 表示的是每个月的周一到周五的每天每时每分钟的0秒都会任务调度一次
     * (cron = "0,1,2,3,4 * * * * MON-FRI")表示的是每个月的周一到周五的每天每时每分钟的0,1,2,3,4秒都会任务调度一次
     * (cron = "0-4 * * * * MON-FRI")表示的是每个月的周一到周五的每天每时每分钟的0到4秒这个区间都会任务调度一次
     * (cron = "0/4 * * * * MON-FRI")表示的是每个月的周一到周五的每天每时每分钟的每隔4秒都会任务调度一次
     * (cron = "0 0 2-4 ? * 4#2")表示的是每个月的第二个星期四的凌晨2到4点的每个整点都调度一次
     */
    //@Scheduled(cron = "0 * * * * MON-FRI")
    //@Scheduled(cron = "0,1,2,3,4 * * * * MON-FRI")
    //@Scheduled(cron = "0-4 * * * * MON-FRI")
    //@Scheduled(cron = "0/4 * * * * MON-FRI")
    //@Scheduled(cron = "0 0 2-4 ? * 4#2")
     public void hello(){
         System.out.println("hello...");
     }

}

