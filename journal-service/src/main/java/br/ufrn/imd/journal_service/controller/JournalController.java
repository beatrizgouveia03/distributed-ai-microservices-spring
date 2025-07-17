package br.ufrn.imd.journal_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.imd.journal_service.client.MicroserviceAiHttpClient;
import br.ufrn.imd.journal_service.entity.JournalEntry;
import br.ufrn.imd.journal_service.service.JournalService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/journal")
public class JournalController {
    private final JournalService service;
    private final MicroserviceAiHttpClient aiClient;

    public JournalController(JournalService service, MicroserviceAiHttpClient aiClient){
        this.service = service;
        this.aiClient = aiClient;
    }

    @PostMapping("advice")
    public ResponseEntity<String> registerEntry(@RequestBody JournalEntry entry, 
        @RequestParam(name = "id", required = false) String id) {
        String response = aiClient.advise(entry, id);

        service.registerEntry(entry);

        System.out.println("Saved entry" + entry.getTitle());

        
        return ResponseEntity.ok(response);
    }
    
    
}
