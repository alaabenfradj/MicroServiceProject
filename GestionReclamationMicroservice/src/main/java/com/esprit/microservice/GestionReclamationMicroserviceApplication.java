package com.esprit.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class GestionReclamationMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionReclamationMicroserviceApplication.class, args);
	}

}
