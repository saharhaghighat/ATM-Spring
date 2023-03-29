package com.atmspring.atmspring.mapper;


import com.atmspring.atmspring.dto.UserDTO;
import com.atmspring.atmspring.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<User, UserDTO> {



}
