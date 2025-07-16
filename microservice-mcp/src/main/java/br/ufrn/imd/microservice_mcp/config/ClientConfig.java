package br.ufrn.imd.microservice_mcp.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClientConfig {
    
    @Bean
    @LoadBalanced
    public WebClient.Builder ClientConfig(){
        return WebClient.builder();
    }
}
