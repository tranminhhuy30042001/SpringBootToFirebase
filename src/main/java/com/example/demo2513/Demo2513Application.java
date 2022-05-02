package com.example.demo2513;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Demo2513Application {

	public static void main(String[] args) {

		SpringApplication.run(Demo2513Application.class, args);


	}
	@RestController
	public class HelloController {
		@GetMapping("/")
		public String index() {
			return "Greetings from Spring Boot!";
		}
	}

}
