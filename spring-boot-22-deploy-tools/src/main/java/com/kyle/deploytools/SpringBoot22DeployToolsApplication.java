package com.kyle.deploytools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 1.热部署需要加入相应的依赖
 * 2.加入依赖在修改文件之后 点击导航条上Build ->Build Project (Ctrl+F9)
 * 这样就不需要重新启动了就能实现热部署了
 */
@SpringBootApplication
public class SpringBoot22DeployToolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot22DeployToolsApplication.class, args);
    }

}
