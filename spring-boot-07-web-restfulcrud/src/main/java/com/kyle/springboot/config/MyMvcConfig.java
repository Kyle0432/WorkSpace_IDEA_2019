package com.kyle.springboot.config;

import com.kyle.springboot.component.LoginHandlerIntercep;
import com.kyle.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: Kyle
 * @date: 2019/9/20 -  15:58
 */
//使用WebMvcConfigurationSupport可以来扩展SpringMvc的功能
@Configuration
public class MyMvcConfig  implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //表示浏览器发送/kyle请求映射到success页面
        registry.addViewController("/kyle").setViewName("success");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }



    /**
     * 现在用的是SpringBoot对SpringMvc自动配置的国际化,
     * 而现在我们需要用我们自己配置的,所以要放到容器里面才生效我们自己配置的,否则默认使用
     * SpringBoot提供的
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns("/**")表示的是拦截任意多层下的任意请求,
        // 但是排除访问首页的请求还有登录的请求也不进行拦截
        //静态资源; *.css, *.js
        //SpringBoot已经做好了静态资源映射
        registry.addInterceptor(new LoginHandlerIntercep()).addPathPatterns("/**").
        excludePathPatterns("/index.html","/","/static/**","/webjars/**","/user/login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //静态文件
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //webjar文件
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }

}
