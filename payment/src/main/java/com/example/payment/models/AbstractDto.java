package com.example.payment.models;

import lombok.Data;

import java.util.Date;
@Data
public class AbstractDto {
    private Long id;
    private Integer version;
    private Date insertTimestamp;
    private Date lastUpdateTimestamp ;
}
