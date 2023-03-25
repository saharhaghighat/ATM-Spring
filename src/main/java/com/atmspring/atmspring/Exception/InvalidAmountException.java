package com.atmspring.atmspring.Exception;

public class InvalidAmountException extends RuntimeException {
    public static final String Message = "That's too much!";

    public InvalidAmountException() {
        super(Message);
    }
}