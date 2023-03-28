package com.atmspring.atmspring.repository;

import com.atmspring.atmspring.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Page<Transaction> findByAccount_Card_CardNumberorOrderByDate(String cardNumber,Pageable pageable);

}
