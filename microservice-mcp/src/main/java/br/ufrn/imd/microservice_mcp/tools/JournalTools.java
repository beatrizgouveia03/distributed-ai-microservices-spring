package br.ufrn.imd.microservice_mcp.tools;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class JournalTools {
    private final WebClient client;

    public JournalTools(WebClient.Builder builder){
        this.client = builder.baseUrl("http://journal-service/journal").build();
    }
}
