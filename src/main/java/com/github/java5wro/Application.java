package com.github.java5wro;

import com.github.java5wro.user.model.User;
import com.github.java5wro.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.UUID;

import static springfox.documentation.builders.PathSelectors.regex;


@EnableSwagger2
@SpringBootApplication
public class Application implements CommandLineRunner {

    private UserRepository userRepository;

    @Autowired
    public Application(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("java5wro")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/api.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring REST Ticket Service Application")
                .description("Spring REST Ticket Service Application")
                .contact("java5wro")
                .license("Apache License Version 2.0")
                .version("2.0")
                .build();
    }

    @Override
    public void run(String... strings) {

        userRepository.save(new User("randomUser","randomUser@gmail.com","password","user"));
    }
}
