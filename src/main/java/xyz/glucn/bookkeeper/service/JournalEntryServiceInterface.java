package xyz.glucn.bookkeeper.service;

import xyz.glucn.bookkeeper.model.JournalEntry;

public interface JournalEntryServiceInterface {
    JournalEntry create(JournalEntry entry);
}
