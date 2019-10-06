package com.kyle.ticket.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.kyle.ticket.service.TicketService;
import org.springframework.stereotype.Component;

/**
 * @author: Kyle
 * @date: 2019/10/5 -  17:39
 */
//同时也把它加载到spring容器当中
@Component
//这里需要注意,这里的@Service是dubbo的service
// 它的作用就是将服务发布到zookeeper也就是注册,
// 该服务也就是TicketService是以全类名的信息注册在zookeeper
@EnableDubbo//这里一定要开启dubbo
@Service
public class TicketServiceImpl  implements TicketService {

    @Override
    public String getTicket() {
        return "<我爱我的祖国>";
    }
}
