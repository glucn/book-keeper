package xyz.glucn.bookkeeper.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

    public JournalEntry() {
    }

    public JournalEntry(Date transactionDate, Date postingDate, String currencyId) {
        this.transactionDate = transactionDate;
        this.postingDate = postingDate;
        this.currencyId = currencyId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Date getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public List<JournalEntryLine> getLines() {
        return lines;
    }

    public void setLines(List<JournalEntryLine> lines) {
        this.lines = lines;
    }
}