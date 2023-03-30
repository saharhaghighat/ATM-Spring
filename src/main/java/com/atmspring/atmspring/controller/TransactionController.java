package com.atmspring.atmspring.controller;


import com.atmspring.atmspring.dto.TransactionDTO;
import com.atmspring.atmspring.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Transaction")
@RequiredArgsConstructor
public class TransactionController {

    private  final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<TransactionDTO> transactionList(@RequestParam String cardNumber){

    }


}
