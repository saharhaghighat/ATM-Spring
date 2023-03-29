package com.atmspring.atmspring.exception;

import org.springframework.http.HttpStatus;

public class AgeException extends BaseException{

    public AgeException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}