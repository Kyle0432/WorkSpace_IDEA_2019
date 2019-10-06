package com.kyle.consumeruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDiscoveryClient//开启发现服务功能,消费者去注册中心发现服务
@SpringBootApplication
public class SpringBoot21SpringcloudConsumerUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot21SpringcloudConsumerUserApplication.class, args);
    }

    @LoadBalanced//使用负载均衡机制
    @Bean//加载到容器中
    public RestTemplate restTemplate(){
       return new RestTemplate();
    }
}
