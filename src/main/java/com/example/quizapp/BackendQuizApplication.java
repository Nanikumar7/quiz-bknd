package com.example.quizapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.quizapp.repository")
public class BackendQuizApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendQuizApplication.class, args);
    }
}


