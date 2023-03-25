package com.atmspring.atmspring.Model;

import com.atmspring.atmspring.Exception.InvalidAmountException;
import com.atmspring.atmspring.Model.Enums.AccountType;
import com.atmspring.atmspring.Model.Enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "account_number",nullable = false,unique = true,length = 16)
    private String accNumber;


    @Column(name="password",nullable = false,length = 20)
    private String password;



    @Column(name = "balance",nullable = false, columnDefinition = "double default 100")
    private Double balance;


    @Column(name = "account_type",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private AccountType accountType;


    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private Card card;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "account",cascade = CascadeType.ALL)
    private List<Transaction> transactions;




    public Account( String accountNumber, String password, Double balance,AccountType accountType) {

        this.accountType = accountType;
        this.accNumber = accountNumber;
        this.password = password;
        this.balance = balance;
    }



    public Account(User user, AccountType accountType, String password) {
        Random random = new Random();
        this.accNumber = String.valueOf(random.nextLong(1000000000, 999999999));
        this.user = user;
        this.accountType = accountType;
        this.password = password;
        this.balance = 50d;
        this.card = new Card(password);
    }

    public void deposit(Double amount) {
        this.balance += amount;
        Transaction transaction = new Transaction(TransactionType.DEPOSIT, amount);
        if (Objects.isNull(transactions)) {
            transactions = new ArrayList<>();
        }
        transactions.add(transaction);
    }

    public void withDraw(Double amount) {
        if (amount < this.balance) {
            this.balance = this.balance - amount;
            Transaction transaction = new Transaction(TransactionType.WITHDRAW, amount);
            if (Objects.isNull(transactions))
                transactions = new ArrayList<>();
            transactions.add(transaction);
        } else
            throw new InvalidAmountException();

    }










}
