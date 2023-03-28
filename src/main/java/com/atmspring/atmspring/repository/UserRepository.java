package com.atmspring.atmspring.repository;

import com.atmspring.atmspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByNationalCode(String nationalCode);
}
