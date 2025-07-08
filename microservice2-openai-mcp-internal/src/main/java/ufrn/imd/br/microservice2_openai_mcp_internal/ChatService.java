package ufrn.imd.br.microservice2_openai_mcp_internal;

import java.util.List;

public interface ChatService {
    String getChatResponse(String userMessage);
    List<Notes> getNotes(String userMessage);
}

  