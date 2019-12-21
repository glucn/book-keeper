package xyz.glucn.bookkeeper.service;

import xyz.glucn.bookkeeper.model.JournalEntry;

import java.util.Optional;

public interface JournalEntryServiceInterface {
    JournalEntry create(JournalEntry entry);

    Optional<JournalEntry> get(Integer id);
}
