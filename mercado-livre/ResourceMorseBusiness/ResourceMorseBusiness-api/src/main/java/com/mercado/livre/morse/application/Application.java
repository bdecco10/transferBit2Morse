package com.mercado.livre.morse.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mercado.livre.morse.endpoint",
		"com.mercado.livre.morse.api",
		"com.mercado.livre.morse.core",
		"com.mercado.livre.morse.entity",
		"com.mercado.livre.morse.application",
		"com.mercado.livre.morse.util",
		"com.mercado.livre.morse.service",
		"com.mercado.livre.morse.service.helper"})
@EnableCircuitBreaker
@EnableHystrixDashboard
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
