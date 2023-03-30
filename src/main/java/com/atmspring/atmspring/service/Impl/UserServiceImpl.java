package com.atmspring.atmspring.service.Impl;

import com.atmspring.atmspring.exception.AgeException;
import com.atmspring.atmspring.exception.InvalidInputException;
import com.atmspring.atmspring.exception.NotFoundException;
import com.atmspring.atmspring.model.User;
import com.atmspring.atmspring.repository.UserRepository;
import com.atmspring.atmspring.service.UserService;
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
            throw new AgeException("age is proper");
        User user = new User(null, fName, lName, nationalCode, bDay);
        return userRepository.save(user);
    }

    @Override
    public User findUserByNationalCode(String nationalCode) {

        return this.userRepository.findByNationalCode(nationalCode).orElseThrow(() -> {
            throw new NotFoundException("Can't find User");
        });
    }

    @Override
    public User getById(Long id){
        return
    }
}
