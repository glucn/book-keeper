package xyz.glucn.bookkeeper.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import xyz.glucn.bookkeeper.model.JournalEntry;

@Repository
public interface JournalEntryRepository extends PagingAndSortingRepository<JournalEntry, Integer> {
}
