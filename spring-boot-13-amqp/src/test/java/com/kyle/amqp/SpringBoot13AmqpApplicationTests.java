package com.kyle.amqp;

import com.kyle.amqp.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot13AmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    /**
     * 可在用代码创建交换器等一些组件,无需一定用客户端管理界面进行创建
     */
    @Test
    public void createExchange(){
        //创建一个交换器并且指定Exchange的类型
        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        System.out.println("创建完成!");

        //创建队列
        amqpAdmin.declareQueue(new Queue("amqpadmin.queue"));

        //创建绑定规则
        amqpAdmin.declareBinding(new Binding("amqpadmin.queue",Binding.DestinationType.QUEUE,
                "amqpadmin.exchange","amqp.haha",null));

    }


    /**
     * 1.单播点对点,发送消息到队列里面
     */
    @Test
    public void contextLoads() {
        //Message需要自己构造一个,定义消息体内容和消息头
        //rabbitTemplate.send(exchange,routeKey,message);

        //object默认当成消息体,只需要传入要发送的对象,自动序列化发送给rabbitmq
        //rabbitTemplate.convertAndSend(exchange,routeKey,object);

        Map<String,Object> map = new HashMap<>();
        map.put("msg1","这是第一个消息");
        map.put("msg2","这是第二个消息");
        map.put("msg3","这是第三个消息");
        map.put("data", Arrays.asList("helloworld",123,true));
        //对象被默认序列化以后发送出去
       // rabbitTemplate.convertAndSend("exchange.direct","kyle.news",map);
        rabbitTemplate.convertAndSend("exchange.direct","caven.news",new Book("name","李星"));
    }

    /**
     * 注意当执行receive()接收数据的这个方法以后,rabbitmq消息队列里面就会移除这条消息了
     */
    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("kyle.news");
        System.out.println(o.getClass());
        //class java.util.HashMap

        //打印出所接收到的消息对象信息
        System.out.println(o);
        //{msg3=这是第三个消息, msg2=这是第二个消息, msg1=这是第一个消息, data=[helloworld, 123, true]}

    }

    @Test
    public void receive2(){
        Object o = rabbitTemplate.receiveAndConvert("caven.news");
        System.out.println(o);
    }



}
