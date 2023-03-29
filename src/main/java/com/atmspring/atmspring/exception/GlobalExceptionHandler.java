package com.atmspring.atmspring.exception;


import com.atmspring.atmspring.dto.ExceptionResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler (BaseException.class)
    public ResponseEntity<ExceptionResponseDTO> handleException(BaseException e){
        ExceptionResponseDTO responseDTO=new ExceptionResponseDTO();
        responseDTO.setMassage(e.getMessage());
        responseDTO.setStatus(e.getHttpStatus().value());
        responseDTO.setTimeStamp(LocalDate.now());
        return new  ResponseEntity<>(responseDTO,e.getHttpStatus());


    }
}
