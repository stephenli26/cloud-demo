package com.eureka.customer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Customer1Application {

    public static void main(String[] args) {
        SpringApplication.run(Customer1Application.class, args);
    }

}