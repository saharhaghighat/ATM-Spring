package com.atmspring.atmspring.Model.Enums;

public enum TransactionType {
    DEPOSIT(1),WITHDRAW(2);

    private Integer value;

    TransactionType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}