package domain;

import java.sql.Timestamp;

public class Transaction {
    private String trasactionId;
    private TransactionType type;
    private String amount;
    private Timestamp time;
    private String note;


    public Transaction(String trasactionId, TransactionType type, String amount, Timestamp time, String note) {
        this.trasactionId = trasactionId;
        this.type = type;
        this.amount = amount;
        this.time = time;
        this.note = note;
    }
}
