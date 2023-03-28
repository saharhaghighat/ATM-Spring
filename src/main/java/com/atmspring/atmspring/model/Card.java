package com.atmspring.atmspring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Random;

@Entity
@Table(name = "card")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "card_number",nullable = false,unique = true)
    private String cardNumber;

    @Column(name = "cvv2",nullable = false)
    private String cvv2;

    @Column(name = "password",nullable = false)
    private String password;


    @Column(name = "expired_date",nullable = false)
    private LocalDate expiredDate;

    public Card( String password) {
        Random random=new Random();
        int num= random.nextInt(100000,9999999);
        this.cardNumber="673245"+num;
        this.cvv2 = String.valueOf(random.nextInt(4));
        this.password = password;
        this.expiredDate =LocalDate.now().plusYears(5);
    }


    public boolean Validation(String pass){
        return pass.equals(this.password);
    }



}
