package com.atmspring.atmspring.service;

import com.atmspring.atmspring.model.Transaction;

import java.io.IOException;
import java.util.List;

public interface TransactionService {
    List<Transaction> LastTenTransaction(String cardNumber);

    void LastTenTransactionsToCsv(String cardNumber) throws IOException;
}
