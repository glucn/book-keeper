package xyz.glucn.bookkeeper.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import xyz.glucn.bookkeeper.model.JournalEntryLine;

public interface JournalEntryLineRepository extends PagingAndSortingRepository<JournalEntryLine, Integer> {
}
