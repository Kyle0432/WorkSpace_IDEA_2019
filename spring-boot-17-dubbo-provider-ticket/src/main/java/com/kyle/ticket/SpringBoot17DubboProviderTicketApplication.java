package com.kyle.ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 1.将服务提供者注册到注册中心
 *    ①引入dubbo和zkclient相关依赖
 *    ②配置dubbo的扫描包和注册中心的地址
 *    ③使用@Service发布服务
 *
 *  Dubbo+Zookeeper组合使用
 * 比如我们在分布式情况下,A模块需要调用B模块,此时问题来了,A需要调用B,B在哪呢?
 * 此时我们就需要一个Zookeeper注册中心,来保存B的地址,A访问注册中心,找到B的地址
 * 之后进行远程调用。Zookeeper就是这个注册中心,Dubbo就是这个分布式的服务的调用框架
 *
 */
@SpringBootApplication
public class SpringBoot17DubboProviderTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot17DubboProviderTicketApplication.class, args);
    }

}
