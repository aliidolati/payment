package com.example.payment.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "TRANSACTION")
@Data
public class Transaction extends AbstractEntity {

    private Date date ;

    private String senderCardNumber ;

    private String receiverCardNumber ;
    private Long amount ;



}
