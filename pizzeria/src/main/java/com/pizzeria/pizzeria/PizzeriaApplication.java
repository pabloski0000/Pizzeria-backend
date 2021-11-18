package com.pizzeria.pizzeria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@ComponentScan
@EntityScan()
@EnableR2dbcRepositories()
public class PizzeriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzeriaApplication.class, args);
	}

}
