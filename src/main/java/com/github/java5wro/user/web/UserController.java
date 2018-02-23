package com.github.java5wro.user.web;

import com.github.java5wro.user.model.UserEntity;
import com.github.java5wro.user.model.UserMapper;
import com.github.java5wro.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Set<UserEntity> getAllUsers() {
        return new HashSet<>(userService.getAllUsers());
    }

    @PostMapping
    public void createUser(@RequestBody @Valid UserMapper user) {
        userService.saveUser(UserMapper.toUserEntity(user));
    }








}
