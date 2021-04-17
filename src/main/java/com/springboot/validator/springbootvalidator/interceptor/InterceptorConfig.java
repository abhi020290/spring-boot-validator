package com.springboot.validator.springbootvalidator.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private LogInteceptor logInteceptor;

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInteceptor).addPathPatterns("/*");
        registry.addInterceptor(authInterceptor).addPathPatterns("/*");
        // registry.addInterceptor(instrumentInterceptor);
    }
}
