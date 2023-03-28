package com.atmspring.atmspring.service.Impl;

import com.atmspring.atmspring.exception.InvalidPasswordException;
import com.atmspring.atmspring.exception.NotFoundException;
import com.atmspring.atmspring.model.Account;
import com.atmspring.atmspring.model.Enums.AccountType;
import com.atmspring.atmspring.model.User;
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

    @Override
    public Account login(String cardNumber, String pass) {
        Account account = this.accountRepository.findByCard_CardNumber(cardNumber).orElseThrow(() -> {
            throw new NotFoundException("Account not found");
        });
        if (account.getCard().Validation(pass))
            return account;
        else
            throw new InvalidPasswordException();
    }

    @Override
    public Account createAccount(User user, Integer Type, String password) {
        AccountType accountType = AccountType.getAccountType(Type);
        Account account = new Account(user, accountType, password);
        accountRepository.save(account);
        return account;
    }

    @Override
    public void moneyTransfer(String card1, String card2, double amount) {
        List<Account> accountList = new ArrayList<>();
        this.accountRepository.findByCard_CardNumber(card1).ifPresentOrElse(account -> {
            Account account2 = this.accountRepository.findByCard_CardNumber(card2).orElseThrow();
            account.withDraw(amount);
            account2.deposit(amount);
            accountRepository.saveAll(accountList);
        }, () -> {
            throw new NotFoundException("Not found Account with this Card Number");
        });
    }


}
