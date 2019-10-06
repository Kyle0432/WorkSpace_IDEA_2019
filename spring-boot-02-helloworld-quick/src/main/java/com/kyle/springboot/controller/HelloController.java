package com.kyle.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Kyle
 * @date: 2019/9/17 -  15:46
 */

//表示的是这个类的所有方法返回的数据直接写给浏览器,而不进行跳转(如果是对象转换为json数据)
/*@ResponseBody
@Controller*/

//@RestController注解是上面两个注解的组合简化,其作用和上面的是一样的,也就是替换上面两个注解
@RestController
public class HelloController {


    @RequestMapping("/hello")
    public String hello(){
        return "Hello world quick";
    }
}
