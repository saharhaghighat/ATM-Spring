package com.atmspring.atmspring.Repository;

import com.atmspring.atmspring.Model.Transaction;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Page<Transaction> findByAccount_Card_CardNumberorOrderByDate(String cardNumber,Pageable pageable);

}
