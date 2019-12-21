package xyz.glucn.bookkeeper.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import xyz.glucn.bookkeeper.model.Account;
import xyz.glucn.bookkeeper.service.AccountServiceInterface;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
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

    @GetMapping("/{id}")
    public ResponseEntity<Account> get(@PathVariable("id") Integer id) {

        Optional<Account> account = accountService.get(id);

        if (account.isEmpty()) {
            // TODO: return correct error code
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(account.get());
    }
}
