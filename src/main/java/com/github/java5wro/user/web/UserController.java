package com.github.java5wro.user.web;

import com.github.java5wro.email.EmailService;
import com.github.java5wro.user.model.UserDTO;
import com.github.java5wro.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Set;

@RestController
@RequestMapping("/api/users")

public class UserController {

    private UserService userService;
    private EmailService emailService;

    @Autowired
    public UserController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
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

//    @PostMapping
//    public void changePassword(@RequestParam("email") String email, @RequestParam("setNewPassword") String newPassword) {
//        UserDTO userToUpdate = userService.findUserByEmail(email);
//        userToUpdate.setPassword(newPassword);
//        userService.saveUser(userToUpdate);
//    }


    @PostMapping("/resetPassword")
    public void resetPassword(@RequestParam("mail") String email, @RequestParam("newPassword") String newPassword) throws IOException {
        UserDTO userDTO = userService.findUserByEmail(email);
        userDTO.setPassword(newPassword);
        userService.saveUser(userDTO);
        emailService.sendEmail(email,userDTO.getName(),"Your password has been changed");
    }







}
