package com.springboot.validator.springbootvalidator.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;

@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Value("${xRequest.id.value}")
    String xRequestId;


    @Value("${xClient.id.value}")
    String xClientId;

    @Value("#{${rolesAllowedForClient}}")
    private Map<String, String> valuesMap;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("AuthInterceptor Interceptor preHandle method Invoked ************");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {

            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            if(headerName.equalsIgnoreCase("X-REQUEST-ID")){
                if(!headerValue.equals(xRequestId)){
                    log.info("AuthInterceptor failed X-REQUEST-ID");
                    return false;
                }
            }
            if(headerName.equalsIgnoreCase("X-CLIENT-ID")){
                if(!headerValue.equals(xClientId)){
                    log.info("AuthInterceptor failed X-CLIENT-ID");
                    return false;
                }
            }

        }
        checkRoles(request);
        log.info("AuthInterceptor success X-CLIENT-ID & X-REQUEST-ID");
        return true;
    }

    private void checkRoles(HttpServletRequest request) {
        Class<? extends HttpServletRequest> aClass = request.getClass();
        RolesAllowed annotation = aClass.getAnnotation(RolesAllowed.class);
        String[] value = annotation.value();
        valuesMap.toString();
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("AuthInterceptor Interceptor postHandle method Invoked ************");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("AuthInterceptor Interceptor afterCompletion method Invoked ************");
    }
}
