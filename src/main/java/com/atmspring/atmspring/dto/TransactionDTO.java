package com.atmspring.atmspring.dto;

import com.atmspring.atmspring.model.Enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private Long id;
    private Double amount;
    private TransactionType transactionType;
    private LocalDate date;


}
