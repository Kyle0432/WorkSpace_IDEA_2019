package com.kyle.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author: Kyle
 * @date: 2019/10/4 -  13:37
 */
//因为这个注解里面带了@Configuration注解,所以在这里就不需要写这个注解了
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    //Ctrl+O 打开能重写的方法

   //定制请求的授权规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //表示斜杠访问首页  让所有人都能进行访问的到，后面的level需要有VIP才能访问
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        //开启自动配置的登录功能,有如下默认规则。
        http.formLogin();
        //1.http.formLogin().loginPage("/userlogin")告诉springsecurity
        // 默认页面改成我们自己写的的登录页,然后指定下我们的页面请求为/userlogin",
        // 就会显示我们的定制的页面,一旦定制loginPage,那么loginPage的post请求是登录
        //2.http.formLogin().usernameParameter("user").passwordParameter("pwd")loginPage("/userlogin")
        //表示在登录页里面的input框属性name必须要和这里设置user一样,才能进行映射,如果不设置
        //usernameParameter("user")默认的是username
        //3../login来到登录页面，如果没有登录,没有权限就会来到登录页面,这个登录页是SpringSecurity自动生成的
        //4..重定向到/login?error表示登录失败,也就是在登录页面上会显示红色的密码信息错误之类的
        //5..默认post形式的/login代表处理登录
        //6.更多消息规定

        //开启自动配置的注销功能 有如下默认规则
        http.logout();
        //1.访问 /logout 表示用户注销,清空session
        //2.注销成功会返回 /login?logout 也就是它会自动返回登录页面,并且显示你已经退出登录了
        //如果你想定制你自己的规则可以如下
        //表示成功后来到首页,这里定制你想返回到哪个页面都行
//        http.logout().logoutSuccessUrl("/");

        //开启记住我的功能  有如下默认规则
        http.rememberMe();
        //http.rememberMe().rememberMeParameter("记住我"),表示自定义文字,而不用默认的
       //1.会在登录的页面有个勾选框,点击完后你退出浏览器,再次进入该页面会自动登录,
        //原理就是登录成功以后,将cookie发给浏览器保存,以后访问页面就带上这个cookie,只要透过检查就免登录
        // 但是点击注销会删除这个cookie,就不会自动登录
    }

    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //报数据放到内存当中,然后在内存中查数据,当然开发可以在jdbcAuthentication()
        //表示的是连向数据库,从数据库里面查询数据


        //可以设置内存指定的登录的账号密码,指定角色
        //不加.passwordEncoder(new MyPasswordEncoder())
        //就不是以明文的方式进行匹配，会报错
        //.passwordEncoder(new MyPasswordEncoder())。
        //这样，页面提交时候，密码以明文的方式进行匹配。
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder())
                .withUser("Kyle").password("123456").roles("VIP1","VIP2");
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder())
                .withUser("Caven").password("123456").roles("VIP2","VIP3");
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder())
                .withUser("Jack").password("123456").roles("VIP3");
    }


}
