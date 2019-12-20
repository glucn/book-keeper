package xyz.glucn.bookkeeper.model;

import javax.persistence.*;
import java.math.BigDecimal;

enum JournalEntryLineType {
    CREDIT, DEBIT;
}

@Entity
public class JournalEntryLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private JournalEntryLineType type;
    private String accountId;
    private String description;
    private BigDecimal amount;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "parentEntry", nullable = false)
    private JournalEntry parentEntry;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JournalEntryLineType getType() {
        return type;
    }

    public void setType(JournalEntryLineType type) {
        this.type = type;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public JournalEntry getParentEntry() {
        return parentEntry;
    }

    public void setParentEntry(JournalEntry parentEntry) {
        this.parentEntry = parentEntry;
    }
}
