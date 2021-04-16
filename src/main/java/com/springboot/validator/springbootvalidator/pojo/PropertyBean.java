package com.springboot.validator.springbootvalidator.pojo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

@Component
@Slf4j
public class PropertyBean {
    @Value("${message.default.property}")
    String defaultProperty;

    @Value("${message.reader.property}")
    String propertyMessage;

    @PostConstruct
    public void init(){
        log.info("PostConstruct method is being called");
        log.info("propertyMessage is {}",propertyMessage);
        log.info("defaultProperty is {}",defaultProperty);

    }

    public String getMessage(){
        return propertyMessage+defaultProperty;
    }
}
