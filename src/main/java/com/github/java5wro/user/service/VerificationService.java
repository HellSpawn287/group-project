package com.github.java5wro.user.service;

import com.github.java5wro.email.EmailService;
import com.github.java5wro.user.VerificationToken;
import com.github.java5wro.user.model.UserDTO;
import com.github.java5wro.user.repository.VerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificationService {

    private final VerificationRepository verificationRepository;
    private final EmailService emailService;

    @Autowired
    public VerificationService(VerificationRepository verificationRepository, EmailService emailService) {
        this.verificationRepository = verificationRepository;
        this.emailService = emailService;
    }

    public void verifyUser(UserDTO userDTO) {

        VerificationToken verificationToken = new VerificationToken(userDTO);
        verificationRepository.save(verificationToken);
        String email = userDTO.getEmail();
        String message = "Confirm your registration by clicking the link below: " + "\n" +
                "http://localhost:8090/api/users/add/" + verificationToken.getToken();
        emailService.sendEmailWithoutTicket(email,"User Verification", message);
    }

    public VerificationToken findTokenByValue(String token) {
        return verificationRepository.findAll().stream().filter(t->t.getToken().equals(token)).findFirst().get();
    }
}
