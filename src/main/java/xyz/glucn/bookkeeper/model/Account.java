package xyz.glucn.bookkeeper.model;

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

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public AccountClassification getClassification() {
        return classification;
    }

    public void setClassification(AccountClassification classification) {
        this.classification = classification;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public AccountSubType getSubType() {
        return subType;
    }

    public void setSubType(AccountSubType subType) {
        this.subType = subType;
    }


    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Date getOpenedAt() {
        return openedAt;
    }

    public void setOpenedAt(Date openedAt) {
        this.openedAt = openedAt;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }
}
