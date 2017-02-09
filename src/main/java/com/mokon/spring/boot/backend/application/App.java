package com.mokon.spring.boot.backend.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(value = "com.mokon.spring.boot.backend.model.repository")
@ComponentScan(basePackages = {"com.mokon.spring.boot.backend.model.service", "com.mokon.spring.boot.backend.controller"})
@EntityScan(basePackages = "com.mokon.spring.boot.backend.model.entity")
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
