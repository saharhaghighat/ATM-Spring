package com.atmspring.atmspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    @NonNull
    private String cardNumber;

    @NonNull
    private String password;

}
