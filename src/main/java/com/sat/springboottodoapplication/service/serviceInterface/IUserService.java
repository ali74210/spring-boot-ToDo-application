package com.sat.springboottodoapplication.service.serviceInterface;

import com.sat.springboottodoapplication.service.DTO.UserDTO;

import java.util.List;

public interface IUserService {

    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO saveUser (UserDTO userDTO);
    UserDTO updateUser (UserDTO userDTO);
    void deleteUserById (Long id);
}
