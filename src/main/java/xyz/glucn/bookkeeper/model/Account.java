package xyz.glucn.bookkeeper.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;

enum AccountClassification {
    Unset, Asset, Equity, Expense, Liability, Revenue
}

// TODO: move this to a DB table?
enum AccountType {
    Unset
}

// TODO: move this to a DB table?
enum AccountSubType {
    Unset
}

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @NotEmpty(message = "name cannot be empty")
    private String name;

    @Column(unique = true)
    private String number;

    private String currencyId;
    private AccountClassification classification;
    private AccountType type;
    private AccountSubType subType;
    private Boolean isActive;
    private Date openedAt;
    @CreatedDate
    private Long createdAt;
}
