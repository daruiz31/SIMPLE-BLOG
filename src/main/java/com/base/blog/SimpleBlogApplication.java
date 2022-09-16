package com.base.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class SimpleBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleBlogApplication.class, args);
	}

}
