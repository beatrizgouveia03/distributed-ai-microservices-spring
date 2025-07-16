package br.ufrn.imd.journal_service.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import br.ufrn.imd.journal_service.entity.JournalEntry;
import br.ufrn.imd.journal_service.repository.JournalEntryRepository;

@Service
@RestController
@EnableDiscoveryClient
public class JournalService {
    private final JournalEntryRepository journalRep;

    public JournalService(JournalEntryRepository journalRep){
        this.journalRep = journalRep;
    }

    public List<JournalEntry> listAll(){
        return journalRep.findAll();
    }

    public String registerEntry(JournalEntry entry){
        return journalRep.registerEntry(entry);

    }
}
