package com.oopsmails.springboot.springbootmicroserviceforeignex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootMicroserviceForeignexApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroserviceForeignexApplication.class, args);
	}
}
