package com.kyle.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 注意:
 * 1.在springboot2.X版本 在你启动服务器默认不打印 监控信息
 * 并且从/health改成/actuator/health
 * 2.在springboot2.X版本,关闭受保护的监控信息 在配置文件中使用
 * management.security.enabled=false 该配置是过期了的
 * 应该使用 management.endpoints.web.exposure.include= *
 * 表示开放所有的web endpoints
 */
@SpringBootApplication
public class SpringBoot23ActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot23ActuatorApplication.class, args);
    }

}
