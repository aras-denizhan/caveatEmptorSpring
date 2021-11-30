package com.example.caveatemptorv2.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class BidDto {
    private Date createdOn;
    private BigDecimal amount;
    private String itemName;
    private String userName;

    public BidDto(Date createdOn, BigDecimal amount, String itemName, String userName) {
        this.createdOn = createdOn;
        this.amount = amount;
        this.itemName = itemName;
        this.userName = userName;
    }
}
