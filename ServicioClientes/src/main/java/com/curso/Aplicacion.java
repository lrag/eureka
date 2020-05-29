package com.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Aplicacion {

	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

}
