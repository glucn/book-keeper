package xyz.glucn.bookkeeper.service;

import xyz.glucn.bookkeeper.model.Account;

import java.util.Optional;

public interface AccountServiceInterface {
    Optional<Account> get(Integer id);

    Optional<Account> getByNumber(String accountNumber);

    Iterable<Account> findAll();

    Account create(Account account);
}
