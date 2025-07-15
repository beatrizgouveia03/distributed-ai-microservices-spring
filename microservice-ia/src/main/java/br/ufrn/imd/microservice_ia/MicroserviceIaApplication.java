package br.ufrn.imd.microservice_ia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceIaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceIaApplication.class, args);
	}

}
