package com.atmspring.atmspring.Service;

import com.atmspring.atmspring.Model.Transaction;

import java.io.IOException;
import java.util.List;

public interface TransactionService {
    List<Transaction> LastTenTransaction(String cardNumber);

    void LastTenTransactionsToCsv(String cardNumber) throws IOException;
}
