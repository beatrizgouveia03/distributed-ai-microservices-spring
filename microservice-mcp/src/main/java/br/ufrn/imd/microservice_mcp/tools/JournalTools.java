package br.ufrn.imd.microservice_mcp.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
@Component
public class JournalTools {
    private final WebClient client;

    public JournalTools(WebClient.Builder builder){
        this.client = builder.baseUrl("http://journal-service/journal").build();
    }

    @Tool(
        name = "advice",
        description = "Advises the person basead on the journal entry that the person wrote"
    ) 
    public String advice(
        @ToolParam(description = "Title of the entry") String title,
        @ToolParam(description = "Daily entry") String entry
    ){

        return entry;
    }
}
