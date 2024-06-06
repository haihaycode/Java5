package com.haihaycode.java5.lab7.config;

import com.haihaycode.java5.lab7.implement.AuthInterceptor;
import com.haihaycode.java5.lab7.implement.GlobalInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    GlobalInterceptor globalInterceptor;
    @Autowired
    AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(globalInterceptor).addPathPatterns("/index", "/about")//cho phép chia sẻ với các req
                .excludePathPatterns("/assets/**","/mail/mail", "/admin/home/index");// ngoại trừ các req
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/account/**", "/admin/**")
                .excludePathPatterns("/assets/**", "/login", "/register");
    }

}
