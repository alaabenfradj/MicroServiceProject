package com.example.clubservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClubServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClubServiceApplication.class, args);
    }

}
