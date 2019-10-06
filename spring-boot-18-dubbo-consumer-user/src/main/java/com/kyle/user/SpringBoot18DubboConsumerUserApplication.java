package com.kyle.user;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1.将服务提供者注册到注册中心
 *    ①引入dubbo和zkclient相关依赖
 *    ②配置dubbo的扫描包和注册中心的地址
 *    ③引用服务
 */

@SpringBootApplication
public class SpringBoot18DubboConsumerUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot18DubboConsumerUserApplication.class, args);
    }

}
