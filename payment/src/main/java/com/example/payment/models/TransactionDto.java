package com.example.payment.models;

import lombok.Data;

import java.util.Date;

@Data
public class TransactionDto {
    private Long id ;
    private Date date ;
    private String senderAccountNumber ;
    private String receiverAccountNumber ;
    private String senderCardNumber ;
    private String receiverCardNumber ;
    private Long amount ;
}
