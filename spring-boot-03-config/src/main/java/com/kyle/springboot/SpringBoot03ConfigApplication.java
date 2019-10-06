package com.kyle.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//通过@ImportResource才可让Spring配置文件里面的内容生效,否则SpringBoot不会自动识别Spring的配置文件
//@ImportResource(locations = {"classpath:beans.xml"})
@SpringBootApplication
public class SpringBoot03ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot03ConfigApplication.class, args);
    }

}
