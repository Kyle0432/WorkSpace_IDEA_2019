package com.kyle.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 这里是的Eureka就是注册中心,和zookeeper是一样的用来注册的
 * eureka就是springcloud的一个组件,springcloud是一个分布式的整体解决方案
 *
 * 1.配置Eureka的相关信息
 * 2.@EnableEurekaServer 开启Eureka服务
 */
@EnableEurekaServer
@SpringBootApplication
public class SpringBoot19SpringcloudEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot19SpringcloudEurekaServerApplication.class, args);
    }

}
