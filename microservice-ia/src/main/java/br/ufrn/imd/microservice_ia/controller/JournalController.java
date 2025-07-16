package br.ufrn.imd.microservice_ia.controller;

import org.springframework.web.bind.annotation.RestController;

import br.ufrn.imd.microservice_ia.services.JournalService;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/journal-advices")
public class JournalController {
    private final JournalService journalService;

    public JournalController(JournalService journalService){
        this.journalService = journalService;
    }

    @PostMapping("/prompt")
    public String getResponse(@RequestParam String prompt, @RequestParam(required=false) String id) {
        if(id == null || id.isBlank()){
            id = UUID.randomUUID().toString();
        }
        return journalService.getResponse(prompt, id);
    }
    
}
