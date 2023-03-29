package com.atmspring.atmspring.controller;


import com.atmspring.atmspring.dto.AccountDTO;
import com.atmspring.atmspring.dto.LoginDTO;
import com.atmspring.atmspring.dto.MoneyTransferDTO;
import com.atmspring.atmspring.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping(value = "")
    public ResponseEntity<AccountDTO> register(@Valid @RequestBody AccountDTO accountDTO){
        AccountDTO account=accountService.createAccount(accountDTO);
        return ResponseEntity.ok(account);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<AccountDTO> login(@Valid @RequestBody LoginDTO dto){
        return ResponseEntity.ok(accountService.login(dto));
    }

    @PostMapping(value = "transaction")
    public ResponseEntity<Void> moneyTransfer(@Valid @RequestBody MoneyTransferDTO dto){
        accountService.moneyTransfer(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
