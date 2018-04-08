package com.oopsmails.spring.cloud.microservicedocker.service.employeedashboard;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class MicroserviceDockerServiceEmployeeDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceDockerServiceEmployeeDashboardApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
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
