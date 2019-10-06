package com.kyle.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author: Kyle
 * @date: 2019/10/3 -  22:58
 */

@Service
public class AsyncService {

    //表示该方法是一个异步的,并且@Async要起效需要在主配置类开启它
    @Async
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理数据中......");
    }
}
