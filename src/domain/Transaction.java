package domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Transaction {
    private String trasactionId;
    private String accountNumber;
    private TransactionType type;
    private Double amount;
    private LocalDateTime time;
    private String note;

    public Transaction(String accountNumber, String trasactionId, TransactionType type, Double amount, LocalDateTime time, String note) {
        this.accountNumber = accountNumber;
        this.trasactionId = trasactionId;
        this.type = type;
        this.amount = amount;
        this.time = time;
        this.note = note;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTrasactionId() {
        return trasactionId;
    }

    public void setTrasactionId(String trasactionId) {
        this.trasactionId = trasactionId;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
