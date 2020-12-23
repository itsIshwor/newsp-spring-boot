package com.ishwor.newp.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ishwor.newp.spring.boot.*")
public class NewspSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewspSpringBootApplication.class, args);
	}

}
