package com.oopsmails.spring.cloud.microservicedocker.employeesearch;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceDockerServiceEmployeeSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceDockerServiceEmployeeSearchApplication.class, args);
    }

    @RefreshScope
    @RestController
    class MessageRestController {

        @Value("${msg:Hello world - Config Server is not working... please check!!!}")
        private String msg;

        @RequestMapping("/configserver/msg")
        String getMsgFromConfigServer() {
            return this.msg;
        }
    }
}
