package com.website.argo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArgoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArgoApplication.class, args);
		System.out.println("Hi");
	}

}
