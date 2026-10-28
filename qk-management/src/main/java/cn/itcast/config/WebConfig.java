package cn.itcast.config;

import cn.itcast.interceptor.LoginInterceptor;
import cn.itcast.interceptor.LoginInterceptor1;
import cn.itcast.interceptor.LoginInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private LoginInterceptor1 loginInterceptor1;

    @Autowired
    private LoginInterceptor2 loginInterceptor2;



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //"/depts"  "/depts/1"
        // 拦截所有请求,除了login和register
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login","/register");
        //registry.addInterceptor(loginInterceptor1).addPathPatterns("/**").excludePathPatterns("/login","/register");
        //registry.addInterceptor(loginInterceptor2).addPathPatterns("/**").excludePathPatterns("/login","/register");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
