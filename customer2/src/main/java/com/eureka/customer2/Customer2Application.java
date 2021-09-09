package com.eureka.customer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Customer2Application {

    public static void main(String[] args) {
        SpringApplication.run(Customer2Application.class, args);
    }

}
