package com.example.ymu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {JooqAutoConfiguration.class})
public class SpringbootJooqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJooqApplication.class, args);
	}
}
