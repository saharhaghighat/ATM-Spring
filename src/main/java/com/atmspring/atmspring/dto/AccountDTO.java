package com.atmspring.atmspring.dto;

import com.atmspring.atmspring.model.Enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private Long id;

    private String accNumber;

    private Double balance;

    private String password;

    private AccountType type;

    private UserDTO user;

    private TransactionDTO transaction;




}
