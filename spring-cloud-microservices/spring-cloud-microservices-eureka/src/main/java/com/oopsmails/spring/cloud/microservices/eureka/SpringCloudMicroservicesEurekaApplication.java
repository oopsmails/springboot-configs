package com.oopsmails.spring.cloud.microservices.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudMicroservicesEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudMicroservicesEurekaApplication.class, args);
    }
}
