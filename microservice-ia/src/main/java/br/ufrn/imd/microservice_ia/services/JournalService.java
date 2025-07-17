package br.ufrn.imd.microservice_ia.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Service;

@Service
public class JournalService{
    private final ChatClient chatClient;

    public JournalService(ChatClient chatClient){
        this.chatClient = chatClient;
    }

    public String getResponse(String prompt, String id){
        return chatClient.prompt()
                         .system(systemSpec -> systemSpec.text("Você é um diário pessoal que dá conselhos com base no que a pessoa escrever"))
                         .advisors(advisor -> advisor.param(ChatMemory.CONVERSATION_ID, id))
                         .user(prompt)
                         .call()
                         .content();
    }
}
