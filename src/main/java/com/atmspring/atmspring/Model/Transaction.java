package com.atmspring.atmspring.Model;


import com.atmspring.atmspring.Model.Enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "amount")
    private Double amount;


    @Column(name = "transaction_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TransactionType type;


    @Column(name = "date", nullable = false)
    private LocalDate date;


    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "account_id",nullable = false)
    private Account account;


    @PrePersist
    public void beforePersist(){
        this.date=LocalDate.now();
    }

    public Transaction(TransactionType transactionType, Double amount) {
        this.type = transactionType;
        this.amount = amount;
    }



    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", Amount=" + amount +
                ", type=" + type +
                ", date=" + date +
                '}';
    }
}
