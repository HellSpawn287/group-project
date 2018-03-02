package com.github.java5wro.user.web;

import com.github.java5wro.email.EmailService;
import com.github.java5wro.user.VerificationToken;
import com.github.java5wro.user.model.UserDTO;
import com.github.java5wro.user.model.UserEntity;
import com.github.java5wro.user.service.UserService;
import com.github.java5wro.user.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Set;

@RestController
@RequestMapping("/api/users")

public class UserController {

    private UserService userService;
    private EmailService emailService;
    private VerificationService verificationService;

    @Autowired
    public UserController(UserService userService, EmailService emailService, VerificationService verificationService) {
        this.userService = userService;
        this.emailService = emailService;
        this.verificationService = verificationService;
    }

    @GetMapping("/all")
    public Set<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/add/{token}")
    public void saveUser(@PathVariable("token") String token) {
        VerificationToken foundToken = verificationService.findTokenByValue(token);
        UserEntity userEntity = foundToken.getUserEntity();
        userEntity.setEnabled(true);
        userService.saveUserEntity(userEntity);
    }

    @PostMapping("/resetPassword")
    public void resetPassword(@RequestParam("mail") String email, @RequestParam("newPassword") String newPassword) throws IOException {
        UserEntity userEntity = userService.findByEmail(email);
        userEntity.setPassword(newPassword);
        userService.saveUserEntity(userEntity);
        emailService.sendEmailWithoutTicket(email,"Password reset confirmation","Your password has been changed");
    }

    @PostMapping("/login")
    public String logIn() {
        return "You are succesfully logged!";
    }







}
