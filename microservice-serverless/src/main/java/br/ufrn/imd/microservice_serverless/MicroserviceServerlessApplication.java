package br.ufrn.imd.microservice_serverless;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceServerlessApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceServerlessApplication.class, args);
	}

}
