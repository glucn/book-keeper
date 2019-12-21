package xyz.glucn.bookkeeper.controller.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import xyz.glucn.bookkeeper.model.JournalEntry;
import xyz.glucn.bookkeeper.service.JournalEntryServiceInterface;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/journalentry")
public class JournalEntryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(JournalEntryController.class);

    @Autowired
    private JournalEntryServiceInterface journalEntryService;

    @PostMapping("/")
    public ResponseEntity<JournalEntry> create(@Valid @RequestBody JournalEntry journalEntry) {

        JournalEntry createdEntry = journalEntryService.create(journalEntry);

        if (createdEntry == null) {
            // TODO: return correct error code
            return ResponseEntity.badRequest().build();
        }

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdEntry.getId())
                .toUri();
        return ResponseEntity.created(uri).body(createdEntry);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JournalEntry> get(@PathVariable("id") Integer id) {

        Optional<JournalEntry> entry = journalEntryService.get(id);

        // TODO: return correct error code
        return entry.map(e -> ResponseEntity.ok().body(e))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
