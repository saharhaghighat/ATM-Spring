package com.atmspring.atmspring.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SharedUserContext {
    private Long userId;
    private String nationalCode;
    private String accNumb;
}
