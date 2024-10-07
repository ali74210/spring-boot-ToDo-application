package com.sat.springboottodoapplication.service.mapper;

import com.sat.springboottodoapplication.DAO.model.User;
import com.sat.springboottodoapplication.service.DTO.UserDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "password", source = "passHash")
    UserDTO toDto(User user);
    @InheritInverseConfiguration
    User toEntity(UserDTO userDTO);
}
