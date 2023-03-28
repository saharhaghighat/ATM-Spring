package com.atmspring.atmspring.service;

import com.atmspring.atmspring.model.Account;
import com.atmspring.atmspring.model.User;

public interface AccountService {
    Account login(String cardNumber, String pass);

    Account createAccount(User user, Integer Type, String password);

    void moneyTransfer(String card1, String card2, double amount);
}
