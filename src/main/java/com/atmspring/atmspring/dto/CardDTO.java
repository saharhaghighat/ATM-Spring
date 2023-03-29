package com.atmspring.atmspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO {

    @NonNull
    private Long id;

    @NonNull
    private String cvv2;

    @NonNull
    private String cardNumber;

}
