package com.kyle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: Kyle
 * @date: 2019/9/16 -  21:50
 */

/**
 * @SpringBootApplication 来标注一个主程序类,说明这是一个Spring Boot应用
 */
@SpringBootApplication
public class HelloWorldMainApplication {

    public static void main(String[] args) {

        /*Spring 应用启动起来,之后就会开启Tomcat的8080端口号,就可以去访问了
        此时就可以知道不需要做过多的配置,SpringMVC的包扫描、视图解析器、前端控制器等等
        都没有配置*/
        SpringApplication.run(HelloWorldMainApplication.class,args);


    }

}
