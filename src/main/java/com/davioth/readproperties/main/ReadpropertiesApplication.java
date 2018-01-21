package com.davioth.readproperties.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.davioth.readproperties"})
public class ReadpropertiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadpropertiesApplication.class, args);
	}
}
