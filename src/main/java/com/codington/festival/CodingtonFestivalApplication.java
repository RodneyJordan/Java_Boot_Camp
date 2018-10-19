package com.codington.festival;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages= {"com.codington.festival"})

public class CodingtonFestivalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodingtonFestivalApplication.class, args);
	}
}
