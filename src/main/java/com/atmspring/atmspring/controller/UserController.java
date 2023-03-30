package com.atmspring.atmspring.controller;


import com.atmspring.atmspring.config.SharedUserContext;
import com.atmspring.atmspring.dto.UserDTO;
import com.atmspring.atmspring.mapper.UserMapper;
import com.atmspring.atmspring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;
    private final SharedUserContext sharedUserContext;


    @GetMapping
    public ResponseEntity<UserDTO> getById (@PathVariable Long id){
        return ResponseEntity.ok(userMapper.toDTO(userService.getById(sharedUserContext.getUserId())));

    }


    public  ResponseEntity<UserDTO> update(@PathVariable Long id, UserDTO dto){

    }

}
