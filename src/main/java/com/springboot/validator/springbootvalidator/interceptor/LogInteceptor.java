package com.springboot.validator.springbootvalidator.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;
import sun.misc.IOUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

@Component
@Slf4j
@Order(value = 2)
public class LogInteceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("LogInteceptor Interceptor PreHandle method Invoked ************");
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        log.info("request method ={} request url ={} request body ={}", request.getMethod(), request.getRequestURL(), getRequestBody(request));
        return true;
    }

    private String getRequestBody(HttpServletRequest request) throws IOException {
        BufferedReader reader = request.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        char[] buffer = new char[10];
        while (reader.read(buffer) != -1) {
            stringBuilder.append(new String(buffer));
            buffer = new char[10];
        }
        reader.close();

        String content = stringBuilder.toString();
        return content;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("LogInteceptor Interceptor postHandle method Invoked ************");
        long startTime = (long) request.getAttribute("startTime");
        long duration = System.currentTimeMillis() - startTime;
        int status = response.getStatus();
        ServletOutputStream outputStream = response.getOutputStream();
        String responseBody = outputStream.toString();
        log.info("response status  {} request url {} response body {}",status, request.getRequestURI(), responseBody);

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("LogInteceptor Interceptor afterCompletion method Invoked ************");

    }
}
