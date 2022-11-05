package com.example.wisdommedical.config;

import com.example.wisdommedical.interceptors.JWTinterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTinterceptor())
                .addPathPatterns("/doctor/**")
                .excludePathPatterns("/doctor/login")
                .excludePathPatterns("/user/**")
                .excludePathPatterns("/doctor/record")
                .excludePathPatterns("/admin/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
