package br.ufrn.imd.journal_service.entity;

public class JournalEntry{
    private String title;
    private String date;
    private String entry;

    public void setTitle(String title){ this.title = title; }

    public String getTitle(){ return title; }

    public void setDate(String date){ this.date = date; }
    
    public String getDate(){ return date; }

    public void setEntry(String entry){ this.entry = entry; }

    public String getEntry(){ return entry; }

}
