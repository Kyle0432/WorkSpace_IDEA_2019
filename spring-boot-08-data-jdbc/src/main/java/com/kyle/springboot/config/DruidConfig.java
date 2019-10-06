package com.kyle.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author: Kyle
 * @date: 2019/9/25 -  13:38
 */
@Configuration
public class DruidConfig {

    //把配置的加入到容器里面,此时配置的其他信息就能生效了
    //这里进行属性的绑定
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
       return new DruidDataSource();
    }
}
