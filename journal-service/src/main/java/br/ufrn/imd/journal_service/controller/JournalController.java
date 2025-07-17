package br.ufrn.imd.journal_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.imd.journal_service.entity.JournalEntry;
import br.ufrn.imd.journal_service.service.JournalService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/journal")
public class JournalController {
    private final JournalService service;

    public JournalController(JournalService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<JournalEntry> writeEntry(@RequestBody JournalEntry entry, @RequestParam(required=false) String id) {
        JournalEntry savedEntry = service.registerEntry(entry);

        return ResponseEntity.ok(savedEntry);
    }

    @GetMapping
    public List<JournalEntry> listEntries() {
        return service.listAll();
    }
    
    
    
}
