package com.atmspring.atmspring.exception;

import org.springframework.http.HttpStatus;

public class InvalidAmountException extends BaseException {

    public InvalidAmountException(String message) {
        super(message,HttpStatus.BAD_REQUEST);
    }
}