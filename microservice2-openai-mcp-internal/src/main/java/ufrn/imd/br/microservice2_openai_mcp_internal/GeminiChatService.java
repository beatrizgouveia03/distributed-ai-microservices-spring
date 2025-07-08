package ufrn.imd.br.microservice2_openai_mcp_internal;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class GeminiChatService implements ChatService {
    private final ChatClient chatClient;

    public GeminiChatService(ChatClient.Builder chatClientBuilder) {
        ChatOptions chatOptions = ChatOptions.builder()
                                        .model("gemini-1.5-flash")
                                        .build();

        this.chatClient = chatClientBuilder.defaultOptions(chatOptions)
                                        .build();
    }

    @Override
    public String getChatResponse(String userMessage) {
        return "Chat response for: " + userMessage;
    }

    @Override
    public List<Notes> getNotes(String userMessage) {
        return List.of(new Notes("Sample Note", "2023"));
    }
    
}
