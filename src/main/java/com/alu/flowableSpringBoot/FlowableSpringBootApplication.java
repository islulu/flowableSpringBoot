package com.alu.flowableSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.alu.flowableSpringBoot")
public class FlowableSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowableSpringBootApplication.class, args);
	}

}
