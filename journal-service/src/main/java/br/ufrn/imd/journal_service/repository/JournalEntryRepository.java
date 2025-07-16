package br.ufrn.imd.journal_service.repository;

import java.util.List;
import java.util.ArrayList;

import br.ufrn.imd.journal_service.entity.JournalEntry;

public class JournalEntryRepository {
    private List<JournalEntry> journal;    

    public JournalEntryRepository(){
        journal = new ArrayList<JournalEntry>();
    }

    public List<JournalEntry> findAll(){
        return journal;
    }

    public String registerEntry(JournalEntry entry){

        journal.add(entry);

        return "Successfully added entry " + entry.getTitle() + " to journal";
    }
}
