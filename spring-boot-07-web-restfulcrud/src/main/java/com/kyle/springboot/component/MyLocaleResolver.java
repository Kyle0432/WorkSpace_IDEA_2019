package com.kyle.springboot.component;

/**
 * @author: Kyle
 * @date: 2019/9/20 -  23:56
 */

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 可以在链接上携带区域信息
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l = httpServletRequest.getParameter("l");
        //如果不带参数的就用系统默认的
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(l)){
            //对_进行符号分割
            String[] s = l.split("_");
            //分割的两个值放入Locale
            locale = new Locale(s[0],s[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
