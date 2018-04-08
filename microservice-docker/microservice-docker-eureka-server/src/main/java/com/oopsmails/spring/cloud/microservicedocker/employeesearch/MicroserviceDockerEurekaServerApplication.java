package com.oopsmails.spring.cloud.microservicedocker.employeesearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MicroserviceDockerEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceDockerEurekaServerApplication.class, args);
    }
}
