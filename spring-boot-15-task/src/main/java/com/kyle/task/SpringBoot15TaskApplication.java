package com.kyle.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * 注意如果在service层用到了一些springboot的注解,
 * 在主配置类一定要开启,否则在service的注解就没用
 */

@EnableScheduling//开启基于注解的定时任务
@EnableAsync  //开启异步注解
@SpringBootApplication
public class SpringBoot15TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot15TaskApplication.class, args);
    }

}
