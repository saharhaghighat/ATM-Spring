package com.atmspring.atmspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {
    private Long id;


    @NonNull
    private  String name;

    @NonNull
    private String familyName;

    @NonNull
    private String nationalCode;

    @NonNull
    private LocalDate birthDate;
}
