package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.query","com.example.service","com.example.scaler.function","com.example.config"})
public class GraphQLWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQLWithSpringBootApplication.class, args);
	}

}
