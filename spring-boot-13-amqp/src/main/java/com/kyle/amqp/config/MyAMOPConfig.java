package com.kyle.amqp.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Kyle
 * @date: 2019/10/2 -  15:26
 */

@Configuration
public class MyAMOPConfig {
    /**
     * MessageConverter消息转换器,在我们发送消息的时候,java api会默认序列化
     * 而此时我们如果需要把发送的消息变成json数据的格式的话可以用MessageConverter消息转换器
     */
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
