package xyz.glucn.bookkeeper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.glucn.bookkeeper.model.Account;
import xyz.glucn.bookkeeper.repository.AccountRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AccountService implements AccountServiceInterface {
    @Autowired
    private AccountRepository repository;

    @Override
    public Optional<Account> get(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Account> getByNumber(String accountNumber) {
        return repository.findByNumber(accountNumber);
    }

    @Override
    public Iterable<Account> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Account create(Account account) {
        // TODO: check if already exists
        return repository.save(account);
    }


}
