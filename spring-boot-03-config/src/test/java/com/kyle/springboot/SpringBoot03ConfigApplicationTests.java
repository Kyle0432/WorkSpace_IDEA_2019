package com.kyle.springboot;

import com.kyle.springboot.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot单元测试
 * 可以在测试期间很方便的类似编码一样进行自动注入等容器的功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot03ConfigApplicationTests {

    //自动注入
    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    public void testHelloService(){
        //判断测试ioc容器里面有没有包含一个id叫helloservice的bean
        boolean helloservice = ioc.containsBean("helloservice");
        System.out.println(helloservice);
        //结果为false,因为SpringBoot里面没有Spring的配置文件,你第三方加入的配置文件
        //必须通过@ImportResource才可让配置文件里面的内容生效,否则SpringBoot不会自动识别
    }

    @Test
    public void contextLoads() {
        System.out.println(person);
    }

}
