package com.oopsmails.spring.cloud.microservicedocker.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
@EnableConfigServer
@SpringBootApplication
public class MicroserviceDockerConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceDockerConfigServerApplication.class, args);
    }
}
