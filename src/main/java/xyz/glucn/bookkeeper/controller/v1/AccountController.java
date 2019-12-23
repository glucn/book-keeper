package xyz.glucn.bookkeeper.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import xyz.glucn.bookkeeper.model.Account;
import xyz.glucn.bookkeeper.service.AccountServiceInterface;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/account")
public class AccountController {
    @Autowired
    private AccountServiceInterface accountService;

    @PostMapping("/")
    public ResponseEntity<Account> create(@Valid @RequestBody Account account) {

        Account createdAccount = accountService.create(account);

        if (createdAccount == null) {
            // TODO: return correct error code
            return ResponseEntity.badRequest().build();
        }

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdAccount.getId())
                .toUri();
        return ResponseEntity.created(uri).body(createdAccount);
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Account>> list() {

        Iterable<Account> accounts = accountService.findAll();

        // TODO: return correct error code
        return ResponseEntity.ok().body(accounts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> get(@PathVariable("id") Integer id) {

        Optional<Account> account = accountService.get(id);

        // TODO: return correct error code
        return account.map(acc -> ResponseEntity.ok().body(acc))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }
}
