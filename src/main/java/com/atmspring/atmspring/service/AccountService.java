package com.atmspring.atmspring.service;

import com.atmspring.atmspring.dto.AccountDTO;
import com.atmspring.atmspring.dto.LoginDTO;
import com.atmspring.atmspring.dto.LoginResponseDTO;
import com.atmspring.atmspring.dto.MoneyTransferDTO;
import com.atmspring.atmspring.model.Account;
import com.atmspring.atmspring.model.User;
import com.atmspring.atmspring.repository.GenericRepository;

public interface AccountService extends GenericRepository<Account,Long> {


    LoginResponseDTO login(LoginDTO dto);

    AccountDTO createAccount(AccountDTO dto);


    void moneyTransfer(MoneyTransferDTO dto);
}
