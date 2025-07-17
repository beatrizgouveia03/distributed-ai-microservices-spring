package br.ufrn.imd.journal_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class JournalEntry{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String entry;
    private long timestamp;

    public JournalEntry(){}

    public JournalEntry(String title, String entry){
        this.title = title;
        this.entry = entry;
        this.timestamp = System.currentTimeMillis();
    }

    public void setTitle(String title){ this.title = title; }

    public String getTitle(){ return title; }

    public void setTimestamp(long timestamp){ this.timestamp = timestamp; }
    
    public long getTimestamp(){ return timestamp; }

    public void setEntry(String entry){ this.entry = entry; }

    public String getEntry(){ return entry; }

    @Override
    public String toString(){
        return "JournalEntry{" +
                "id=" + id +
                ", title='" + title + "\'" +
                ", entry='" + entry + "\'" +
                ", timestamp=" + timestamp + "}";
    }

}
