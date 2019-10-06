package com.kyle.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot06LoggingApplicationTests {

    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void contextLoads() {
        //这里我们System.out.println();这种方式打印信息日志了

        //日志的级别;
        //由低到高   trace<debug<info<warn<error
        //可以调整需要输出的日志级别,日志就只会在这个级别以及以后的高级别生效
         logger.trace("这是trace日志");
         logger.debug("这是debug日志");
         //SpringBoot默认给我们使用的是info级别的,所以只会输出info及以后的日志记录
        //如果需要调整级别可以在application全局配置文件里面进行配置
         logger.info("这是info日志");
         logger.warn("这是warn日志");
         logger.error("这是error日志");
    }

}
