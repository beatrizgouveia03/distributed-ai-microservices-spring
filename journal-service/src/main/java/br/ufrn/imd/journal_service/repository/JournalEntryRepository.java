package br.ufrn.imd.journal_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrn.imd.journal_service.entity.JournalEntry;

public interface JournalEntryRepository extends JpaRepository<JournalEntry, Long> {
}
