package com.kyle.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author: Kyle
 * @date: 2019/9/21 -  10:07
 */
@Controller
public class LoginController {
//    @PutMapping
//    @DeleteMapping
//    @GetMapping
   // @RequestMapping(value = "/user/login",method = RequestMethod.POST)
   //为了方便可以写一个简化的注解,作用和上面的是一样的
    @PostMapping(value = "/user/login")
    //用@RequestParam("username")明确的告诉它从请求参数里面获取username,
    //如果用@RequestParam("username")标注了username属性一旦没有提交就会报错
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session){
        if(!StringUtils.isEmpty(username) && "12345".equals(password)){
            //登录成功,防止表单重复提交,可以重定向到主页
            //表示先重定向到main.html,然后main.html再跳转到dashboard.html页面
            //当然这样是有问题的,登录成功后会重定向到main.html,那如果直接在项目
            //路径下输入localhost:8080/crud/main.html就可以不经过登录进去主页面了
            //这样是不可行的,所以要使用拦截器进行拦截登录拦截

            //这里只要登录了用户就会在session中存在
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            //登录失败
            map.put("msg","用户名密码错误");
            return "login";
        }
    }
}
