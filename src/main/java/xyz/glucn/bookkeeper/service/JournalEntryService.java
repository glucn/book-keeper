package xyz.glucn.bookkeeper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.glucn.bookkeeper.model.JournalEntry;
import xyz.glucn.bookkeeper.model.JournalEntryLine;
import xyz.glucn.bookkeeper.repository.JournalEntryLineRepository;
import xyz.glucn.bookkeeper.repository.JournalEntryRepository;

@Service
public class JournalEntryService implements JournalEntryServiceInterface {
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private JournalEntryLineRepository journalEntryLineRepository;

    @Override
    @Transactional
    public JournalEntry create(JournalEntry entry) {
        // TODO: validate

        JournalEntry created = journalEntryRepository.save(new JournalEntry(entry.getTransactionDate(), entry.getPostingDate(), entry.getCurrencyId()));

        for (JournalEntryLine line: entry.getLines()) {
            line.setParentEntry(created);
            journalEntryLineRepository.save(line);
        }

        created.setLines(entry.getLines());
        return created;
    }

}
