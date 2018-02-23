package com.github.java5wro;

import com.github.java5wro.email.EmailService;
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
import static springfox.documentation.builders.PathSelectors.regex;


@EnableSwagger2
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);


    }

    @Bean
    CommandLineRunner commandLineRunner (EmailService es) {
        return args -> {
//            es.sendEmail("javawro5@gmail.com", "test2", "Thank you for using our service. \n Please find attached ticket and invoice.\n Love \n Krzysiu <3");
        };
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

}
