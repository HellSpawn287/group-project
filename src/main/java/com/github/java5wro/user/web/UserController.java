package com.github.java5wro.user.web;

import com.github.java5wro.user.model.UserDTO;
import com.github.java5wro.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public Set<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getOneUser(@PathVariable("id") String userId) {
        return userService.findUserById(Long.parseLong(userId));
    }

    @PostMapping
    public void createUser(UserDTO userDTO) {
        userService.saveUser(userDTO);
    }









}
