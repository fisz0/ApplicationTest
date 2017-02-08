package com.mokon.spring.boot.backend.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.mokon.*")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
