package com.atmspring.atmspring.Service;

import com.atmspring.atmspring.Model.Account;
import com.atmspring.atmspring.Model.User;

public interface AccountService {
    Account login(String cardNumber, String pass);

    Account createAccount(User user, Integer Type, String password);

    void moneyTransfer(String card1, String card2, double amount);
}
