package com.atmspring.atmspring.Service;

import com.atmspring.atmspring.Model.User;

import java.time.LocalDate;

public interface UserService {
    User createUser(String fName, String lName, String nationalCode, LocalDate bDay);

    User findUserByNationalCode(String nationalCode);
}
