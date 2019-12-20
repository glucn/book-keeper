package xyz.glucn.bookkeeper.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.glucn.bookkeeper.model.Account;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
    public Optional<Account> findByNumber(String number);
}
