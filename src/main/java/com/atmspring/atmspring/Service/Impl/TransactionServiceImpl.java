package com.atmspring.atmspring.Service.Impl;

import com.atmspring.atmspring.Model.Transaction;
import com.atmspring.atmspring.Repository.TransactionRepository;
import com.atmspring.atmspring.Service.CsvService;
import com.atmspring.atmspring.Service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final CsvService csvService;

    @Override
    public List<Transaction> LastTenTransaction(String cardNumber){
        return  transactionRepository.findByAccount_Card_CardNumberorOrderByDate(cardNumber, PageRequest.of(0,10)).getContent();
    }

    @Override
    public void LastTenTransactionsToCsv(String cardNumber) throws IOException {
        List<Transaction> transactions = LastTenTransaction(cardNumber);
        String[] header = {"amount", "transactionType", "date"};
        List<String[]> records = new ArrayList<>();
        transactions.forEach(transaction -> {
            String[] item = {String.valueOf(transaction.getAmount()), String.valueOf(transaction.getType()), String.valueOf(transaction.getDate())};
            records.add(item);
        });

        csvService.writer(header, records, "transaction");

    }





}
