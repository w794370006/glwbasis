package com.glw.basis.item.config.manageconfig;

import com.glw.basis.item.core.web.interceptor.SessionInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 后台管理 session 拦截器
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加 后台管理session拦截器
        registry.addInterceptor(SessionInterceptor())
                .addPathPatterns("/**")//拦截所有请求
                .excludePathPatterns("/app/**","/api/**");//不拦截请求
    }

    @Bean
    public SessionInterceptor SessionInterceptor() {
        return new SessionInterceptor();
    }


}