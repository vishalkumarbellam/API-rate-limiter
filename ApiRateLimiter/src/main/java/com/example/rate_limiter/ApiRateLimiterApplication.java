package com.example.rate_limiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ApiRateLimiterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRateLimiterApplication.class, args);
	}

}
