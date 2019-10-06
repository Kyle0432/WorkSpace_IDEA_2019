package com.kyle.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kyle.ticket.service.TicketService;
import org.springframework.stereotype.Service;

/**
 * @author: Kyle
 * @date: 2019/10/5 -  17:43
 */
@Service //这里的注解标注的是spring的而不是dubbo
public class UserService {

    /**
     * @Reference 表示的是远程引用
     * 它是怎么引用的?
     * 它是按照TicketService的全类名进行匹配的,
     * 看谁在注册中心注册TicketService的全类名服务
     */
    @Reference
    TicketService ticketService;

    public void hello(){
        String ticket = ticketService.getTicket();
        System.out.println("买到票了"+ticket);
    }
}
