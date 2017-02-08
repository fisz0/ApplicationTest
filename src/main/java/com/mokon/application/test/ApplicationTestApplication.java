package com.mokon.application.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.mokon.*")
public class ApplicationTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationTestApplication.class, args);
	}
}
