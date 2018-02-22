package com.github.java5wro;

import com.github.java5wro.email.EmailService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.io.IOException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);


    }

    @Bean
    CommandLineRunner commandLineRunner (EmailService es) {
        return args -> {
            es.sendEmail("okromuszczynska@gmail.com", "test2", "DUPA!!!");
        };
    }
}
