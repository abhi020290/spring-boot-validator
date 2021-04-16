package com.springboot.validator.springbootvalidator.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

    @NotNull(message = "Id can not be null")
    private long id;
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotNull(message = "Address cannot be null")
    @NotBlank(message = "Address cannot be blank")
    private String address;
    //@Size(max =99999, min =123 ,message = "ZipCode should be 4 digit long")
    @NotNull(message = "Address cannot be null")
    @Digits(integer = 5, fraction = 0, message = "Zipcode should be 5 digit number")
    private Integer zipCode;
    @NotBlank(message = "Address cannot be blank")
    private String state;
    @NotBlank(message = "Address cannot be blank")
    private String countryCode;

    @PaymentValidator
    private Payment payment;
}
