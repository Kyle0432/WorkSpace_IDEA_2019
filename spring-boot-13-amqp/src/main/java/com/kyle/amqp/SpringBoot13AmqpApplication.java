package com.kyle.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 自动配置
 * 1.RabbitAutoConfiguration
 * 2.有自动配置了连接工厂 ConnectionFactory
 * 3.RabbitProperties 封装了 RabbitMQ的配置
 * 4.RabbitTemplate  给RabbitMQ发送和接收信息       (代码应用在测试类)
 * 5.AmqpAdmin RabbitMQ 系统管理组件
 *   AmqpAdmin: 创建和删除 Queue,Exchange,Binding
 * 6.@EnableRabbit + @RabbitListener 监听消息队列的内容
 */
@EnableRabbit  //开启基于注解的rabbitmq模式
@SpringBootApplication
public class SpringBoot13AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot13AmqpApplication.class, args);
    }

}
