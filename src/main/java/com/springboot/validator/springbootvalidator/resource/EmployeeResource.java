package com.springboot.validator.springbootvalidator.resource;

import com.springboot.validator.springbootvalidator.pojo.Employee;
import com.springboot.validator.springbootvalidator.pojo.PropertyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class EmployeeResource {

    @Autowired
    private PropertyBean propertyBean;

    @PostMapping("employee")
    ResponseEntity<Employee> handleInput(@Valid @RequestBody Employee employee){
        return ResponseEntity.ok(employee);
    }

    @GetMapping("message")
    ResponseEntity<String> handleMessage(){
        return ResponseEntity.ok(propertyBean.getMessage());
    }
}
