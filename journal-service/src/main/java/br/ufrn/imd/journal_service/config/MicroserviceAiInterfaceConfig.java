package br.ufrn.imd.journal_service.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import br.ufrn.imd.journal_service.client.MicroserviceAiHttpClient;

@Configuration
public class MicroserviceAiInterfaceConfig {
    
    @Bean(name = "AIWebClientBuilder")
    @LoadBalanced
    public WebClient.Builder loadbalancerWebClientBuilder(){
        return WebClient.builder();
    }

    @Bean
    public MicroserviceAiHttpClient microserviceAiClient(@Qualifier("AIWebClientBuilder") WebClient.Builder webClientBuilder){
        WebClient microserviceAiWebClient = webClientBuilder.baseUrl("http://microservice-ai")
                                                            .build();
        
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(WebClientAdapter.create(microserviceAiWebClient))
                                                                 .build();
        
        return factory.createClient(MicroserviceAiHttpClient.class);
    }
}
