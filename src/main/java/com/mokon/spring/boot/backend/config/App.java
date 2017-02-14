package com.mokon.spring.boot.backend.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(value = "com.mokon.spring.boot.backend.repository")
@ComponentScan(basePackages = {"com.mokon.spring.boot.backend.service",
    "com.mokon.spring.boot.backend.config",
    "com.mokon.spring.boot.backend.controller",
    "com.mokon.spring.boot.backend.domain.validator"})
@EntityScan(basePackages = "com.mokon.spring.boot.backend.model.entity")
public class App extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }
}
