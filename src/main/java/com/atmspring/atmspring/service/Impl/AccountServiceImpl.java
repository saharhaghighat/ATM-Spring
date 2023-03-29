package com.atmspring.atmspring.service.Impl;

import com.atmspring.atmspring.dto.AccountDTO;
import com.atmspring.atmspring.dto.LoginDTO;
import com.atmspring.atmspring.dto.MoneyTransferDTO;
import com.atmspring.atmspring.exception.NotFoundException;
import com.atmspring.atmspring.mapper.AccountMapper;
import com.atmspring.atmspring.model.Account;
import com.atmspring.atmspring.repository.AccountRepository;
import com.atmspring.atmspring.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final UserServiceImpl userService;
    private final AccountMapper accountMapper;

    @Override
    public AccountDTO login(LoginDTO dto) {
        Account account = accountRepository.findByCard_CardNumber(dto.getCardNumber()).orElseThrow();
        if (account.getCard().Validation(dto.getPassword()))
            accountMapper.toDTO(account);
        throw  new RuntimeException();
    }

    @Override
    public AccountDTO createAccount(AccountDTO dto) {
        Account account=accountMapper.toEntity(dto);
        return accountMapper.toDTO(accountRepository.save(account));

    }

    @Override
    public void moneyTransfer(MoneyTransferDTO dto) {
        List<Account> accountList = new ArrayList<>();
        this.accountRepository.findByCard_CardNumber(dto.getCardNumb1()).ifPresentOrElse(account -> {
            Account account2 = this.accountRepository.findByCard_CardNumber(dto.getCardNumb2()).orElseThrow();
            account.withDraw(dto.getAmount());
            account2.deposit(dto.getAmount());
            accountList.add(account);
            accountList.add(account2);
            accountRepository.saveAll(accountList);
        }, () -> {
            throw new NotFoundException("Not found Account with this Card Number");
        });
    }


}
