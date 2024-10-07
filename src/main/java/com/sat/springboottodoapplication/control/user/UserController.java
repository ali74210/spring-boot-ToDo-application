package com.sat.springboottodoapplication.control.user;

import com.sat.springboottodoapplication.service.DTO.UserDTO;
import com.sat.springboottodoapplication.service.imple.UserService;
import com.sat.springboottodoapplication.service.serviceInterface.IUserService;
import com.sat.springboottodoapplication.service.serviceInterface.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(path = "/user/v1")
public class UserController {

    @Autowired
    private IUserService iuserService;

    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/user/v1/
     * Purpose: Fetches all the users in the user table
     * @return List of users
     */
    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok().body(iuserService.getAllUsers());
    }

    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/user/v1/1 (or any other id)
     * Purpose: Fetches user with the given id
     * @param id - user id
     * @return user with the given id
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id)
    {
        return ResponseEntity.ok().body(iuserService.getUserById(id));
    }

    /**
     * This method is called when a POST request is made
     * URL: localhost:8080/user/v1/
     * Purpose: Save a User entity
     * @param user - Request body is a User entity
     * @return Saved User entity
     */
    @PostMapping("")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO user)
    {
        return ResponseEntity.ok().body(iuserService.saveUser(user));
    }

    /**
     * This method is called when a PUT request is made
     * URL: localhost:8080/user/v1/
     * Purpose: Update a User entity
     * @param user - User entity to be updated
     * @return Updated User
     */
    @PutMapping("/")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user)
    {
        return ResponseEntity.ok().body(iuserService.updateUser(user));
    }

    /**
     * This method is called when a PUT request is made
     * URL: localhost:8080/user/v1/1 (or any other id)
     * Purpose: Delete a User entity
     * @param id - user's id to be deleted
     * @return a String message indicating user record has been deleted successfully
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id)
    {
        iuserService.deleteUserById(id);
        return ResponseEntity.ok().body("Deleted user successfully");
    }

}
