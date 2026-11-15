package domain;

public class Account {
    private String accountNumber;
    private String customerName;
    private Double money;
    private String accountType;


    public Account(String accountNumber, String customerName, Double money, String accountType) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.money = money;
        this.accountType = accountType;
    }
}
