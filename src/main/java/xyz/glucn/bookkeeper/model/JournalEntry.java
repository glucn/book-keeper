package xyz.glucn.bookkeeper.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class JournalEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    private Date transactionDate;
    private Date postingDate;
    private String currencyId;

    @OneToMany(mappedBy = "parentEntry", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<JournalEntryLine> lines = new ArrayList<>();

    @CreatedDate
    private Long createdAt;

    public JournalEntry(Date transactionDate, Date postingDate, String currencyId) {
        this.transactionDate = transactionDate;
        this.postingDate = postingDate;
        this.currencyId = currencyId;
    }
}