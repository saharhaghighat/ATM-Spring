package com.atmspring.atmspring.exception;

import org.springframework.http.HttpStatus;

public class InvalidInputException extends BaseException{
    public InvalidInputException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
