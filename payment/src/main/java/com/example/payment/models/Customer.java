package com.example.payment.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "SECOND_CUSTOMERS")
@Audited
@Data
@EntityListeners(AuditingEntityListener.class)
public class Customer extends AbstractEntity {

    private String firstName ;
    private String lastName ;
    private Integer age ;
    @Column(unique = true)
    private String cardNumber ;
    private Long balance ;
    @Enumerated(EnumType.STRING)
    Gender gender ;



}
