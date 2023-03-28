package com.atmspring.atmspring.service;

import com.atmspring.atmspring.model.User;

import java.time.LocalDate;

public interface UserService {
    User createUser(String fName, String lName, String nationalCode, LocalDate bDay);

    User findUserByNationalCode(String nationalCode);
}
