package com.kyle.amqp.service;

import com.kyle.amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author: Kyle
 * @date: 2019/10/2 -  15:55
 */

@Service
public class BookService {
    /**\
     *进行对消息队列的监听,指定需要监听的队列名称
     * 只要这个消息队列有内容进来,这个方法就会 被调用
     */
    //同时需要让 @RabbitListener注解起作用,我们要在主配置类那里开启基于注解的rabbitmq
    @RabbitListener(queues = "kyle.news")
    public void receive(Book book){
        System.out.println("收到消息:"+book);
    }

    /**
     * 获取其他消息  比如消息体 和消息头等
     */
    public void  receive2(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
