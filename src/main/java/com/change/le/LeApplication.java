package com.change.le;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class LeApplication {

	@GetMapping("/")
	public String index(){
		return "index";
	}

	public static void main(String[] args) {
		SpringApplication.run(LeApplication.class, args);
	}

}
