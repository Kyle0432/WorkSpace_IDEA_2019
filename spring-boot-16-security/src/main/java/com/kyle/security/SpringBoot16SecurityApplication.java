package com.kyle.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 1.引入SpringSecurity的依赖
 * 2.编写SpringSecurity的配置类
 * 3.控制请求的访问权限
 */
@SpringBootApplication
public class SpringBoot16SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot16SecurityApplication.class, args);
    }

}
