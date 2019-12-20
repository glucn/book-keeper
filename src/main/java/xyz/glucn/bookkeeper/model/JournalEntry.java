package xyz.glucn.bookkeeper.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class JournalEntry {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private Date transactionDate;
  private Date postingDate;
  private String currencyId;

  @OneToMany(mappedBy="parentEntry", cascade = CascadeType.PERSIST)
  private List<JournalEntryLine> lines = new ArrayList<>();

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