package com.atmspring.atmspring.Model.Enums;

import com.atmspring.atmspring.Exception.InvalidInputException;

public enum AccountType {
    SEPORDEH(2),JARI(1),GHARZOL_HASANEH(3);
    private Integer value;

    AccountType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
    public static AccountType getAccountType(Integer value){
        for (AccountType accountType: values()){
            if (accountType.getValue().equals(value))
                return accountType;
        }
        throw new InvalidInputException("invalid value.");
    }
}
