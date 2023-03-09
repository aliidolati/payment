package com.example.payment.models;

import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class CustomerDto {
    private Long id ;
    private String firstName ;
    private String lastName ;
    private Integer age ;
    private String cardNumber ;
    private String accountNumber ;
    private Long balance ;
    Gender gender ;


}
