package br.ufrn.imd.microservice_mcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceMcpApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceMcpApplication.class, args);
	}

}
