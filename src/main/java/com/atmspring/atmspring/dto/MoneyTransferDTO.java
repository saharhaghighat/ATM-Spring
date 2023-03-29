package com.atmspring.atmspring.dto;


import lombok.Data;

@Data
public class MoneyTransferDTO {
    private String cardNumb1;

    private String cardNumb2;

    private Double amount;
}
