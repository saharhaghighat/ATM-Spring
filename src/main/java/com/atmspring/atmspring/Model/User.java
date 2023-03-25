package com.atmspring.atmspring.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "name",nullable = false,length = 10)
    private String name;


    @Column(name = "family_name",nullable = false,length = 10)
    private String familyName;

    @Column(name = "national_code",nullable = false,length = 10,unique = true)
    private String nationalCode;


    @Column(name = "birth_date",nullable = false,length = 10)
    private LocalDate birthDate;



}
