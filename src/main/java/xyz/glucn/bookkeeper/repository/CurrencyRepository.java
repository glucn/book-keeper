package xyz.glucn.bookkeeper.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.glucn.bookkeeper.model.Currency;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, Integer> {
}
