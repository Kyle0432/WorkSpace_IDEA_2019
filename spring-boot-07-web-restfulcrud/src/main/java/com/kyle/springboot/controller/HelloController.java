package com.kyle.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

/**
 * @author: Kyle
 * @date: 2019/9/19 -  11:09
 */
@Controller
public class HelloController {
    //因为你在访问时输入/会默认去静态资源文件夹(public、resources、static)下找index.html,而我们要访问的index.html是在
    //thymeleaf文件下的index.html,所以可以通过/或者/index.html访问的都是thymeleaf下的index.html
    //当然也可以在MyMvcConfig里面进行配置,更加方便

//       @RequestMapping({"/","/index.html"})
//       public String index(){
//           return "login";
//       }

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }


    //查出一些数据,在页面上显示
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("张三","李四","王五"));
        //classpath:/templates/success.html
        return "success";
    }

}
