package com.springboot.validator.springbootvalidator.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Payment {
    @NotNull(message = "paymentId cannot be null")
    @NotBlank(message = "paymentId cannot be blank")
    private String paymentId;
    @NotNull(message = "transactionId cannot be null")
    @NotBlank(message = "transactionId cannot be blank")
    private String transactionId;
    @NotNull(message = "authStatus cannot be null")
    @NotBlank(message = "authStatus cannot be blank")
    private String authStatus;
}
