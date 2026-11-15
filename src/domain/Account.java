package domain;

public class Account {
    private String accountNumber;
    private String customerID;
    private Double money;
    private String accountType;


    public Account(String accountNumber, String customerID, Double money, String accountType) {
        this.accountNumber = accountNumber;
        this.customerID = customerID;
        this.money = money;
        this.accountType = accountType;


    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
