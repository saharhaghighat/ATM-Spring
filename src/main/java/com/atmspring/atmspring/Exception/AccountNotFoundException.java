package com.atmspring.atmspring.Exception;


public class AccountNotFoundException extends RuntimeException {
    public static final String Message = "model.Account not found";
    public AccountNotFoundException() {
        super(Message);
    }
}
