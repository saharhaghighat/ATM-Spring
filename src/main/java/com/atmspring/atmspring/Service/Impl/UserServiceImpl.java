package com.atmspring.atmspring.Service.Impl;

import com.atmspring.atmspring.Exception.AgeException;
import com.atmspring.atmspring.Exception.InvalidInputException;
import com.atmspring.atmspring.Exception.NotFoundException;
import com.atmspring.atmspring.Model.User;
import com.atmspring.atmspring.Repository.UserRepository;
import com.atmspring.atmspring.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public User createUser(String fName, String lName, String nationalCode, LocalDate bDay) {

        if (userRepository.findByNationalCode(nationalCode).isPresent()) {
            throw new InvalidInputException("User already exist.");
        }

        if (LocalDate.now().getYear() - bDay.getYear() < 18)
            throw new AgeException();
        User user = new User(null, fName, lName, nationalCode, bDay);
        return userRepository.save(user);
    }

    @Override
    public User findUserByNationalCode(String nationalCode) {

        return this.userRepository.findByNationalCode(nationalCode).orElseThrow(() -> {
            throw new NotFoundException("Can't find User");
        });
    }
}
