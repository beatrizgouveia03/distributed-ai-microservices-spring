package ufrn.imd.br.microservice2_openai_mcp_internal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromptController {
    private final ChatService chatService;

    public PromptController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("prompt")
    public String getResponse(@RequestParam String userMessage) {
        String response = chatService.getChatResponse(userMessage);
        
        return response;
    }

    @GetMapping("notes")
    public String getNotes() {
        return chatService.getNotes("Sample user message")
                .stream()
                .map(note -> note.name() + " - " + note.period())
                .reduce("", (acc, note) -> acc + note + "\n");
    }
    
}
