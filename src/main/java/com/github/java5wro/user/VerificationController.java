package com.github.java5wro.user;

import com.github.java5wro.user.model.UserDTO;
import com.github.java5wro.user.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")
public class VerificationController {

    private VerificationService verificationService;

    @Autowired
    public VerificationController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @PostMapping("/verify")
    public void verifyUser(UserDTO userDTO) {
        verificationService.verifyUser(userDTO);
    }



}
