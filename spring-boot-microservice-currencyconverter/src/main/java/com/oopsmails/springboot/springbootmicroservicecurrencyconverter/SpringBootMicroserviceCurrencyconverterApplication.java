package com.oopsmails.springboot.springbootmicroservicecurrencyconverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.oopsmails.springboot.springbootmicroservicecurrencyconverter")
@EnableDiscoveryClient
public class SpringBootMicroserviceCurrencyconverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroserviceCurrencyconverterApplication.class, args);
	}
}
