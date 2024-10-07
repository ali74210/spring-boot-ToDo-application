package com.sat.springboottodoapplication.service.imple;

import com.sat.springboottodoapplication.DAO.impl.UserRepo;
import com.sat.springboottodoapplication.DAO.model.Task;
import com.sat.springboottodoapplication.DAO.model.User;
import com.sat.springboottodoapplication.service.DTO.TaskDTO;
import com.sat.springboottodoapplication.service.DTO.UserDTO;
import com.sat.springboottodoapplication.service.mapper.UserMapper;
import com.sat.springboottodoapplication.service.serviceInterface.IUserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService implements IUserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private final UserMapper userMapper;

    public List<UserDTO> getAllUsers(){
        List<User> users = userRepo.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        users.forEach(task -> {
            userDTOS.add(userMapper.toDto(task));
        });
        return userDTOS;
    }

    public UserDTO getUserById(Long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return userMapper.toDto(user);
    }


    public UserDTO saveUser (UserDTO userDTO){
        User savedUser = userRepo.save(userMapper.toEntity(userDTO));
//        log.info("User with id: {} saved successfully", savedUser.getId());
        return userDTO;
    }

    public UserDTO updateUser (UserDTO userDTO) {
        Optional<User> existingUser = userRepo.findById(userMapper.toEntity(userDTO).getId());
        User updatedUser = userRepo.save(existingUser.get());

//        log.info("User with id: {} updated successfully", updatedUser.getId());
        return userMapper.toDto(updatedUser);
    }

    public void deleteUserById (Long id) {
        userRepo.deleteById(id);
    }

    public UserService(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }
}

