package br.ufrn.imd.microservice_mcp;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import br.ufrn.imd.microservice_mcp.tools.JournalTools;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceMcpApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceMcpApplication.class, args);
	}

	@Bean
	public ToolCallbackProvider callBackJournalTools(JournalTools journalTools){
		return MethodToolCallbackProvider.builder()
										 .toolObjects(journalTools)
										 .build();
	}

}
