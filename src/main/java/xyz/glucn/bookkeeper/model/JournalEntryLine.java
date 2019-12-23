package xyz.glucn.bookkeeper.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;

enum JournalEntryLineType {
    CREDIT, DEBIT
}

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class JournalEntryLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Integer id;

    private JournalEntryLineType type;
    private String accountId;
    private String description;
    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private JournalEntry parentEntry;

    @CreatedDate
    private Long createdAt;
}
