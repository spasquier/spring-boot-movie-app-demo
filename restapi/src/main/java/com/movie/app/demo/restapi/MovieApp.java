package com.movie.app.demo.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.movie.app.demo"})
@EntityScan(basePackages = {"com.movie.app.demo"})
@EnableJpaRepositories(basePackages = {"com.movie.app.demo"})
public class MovieApp {

	public static void main(String[] args) {
		SpringApplication.run(MovieApp.class, args);
	}

}