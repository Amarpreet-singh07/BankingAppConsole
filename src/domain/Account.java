package domain;

public class Account {
    private String accountNumber;
    private String customerID;
    private Double money;
    private String accountType;


    public Account(String accountNumber, String customerID, String accountType) {
        this.accountNumber = accountNumber;
        this.customerID = customerID;

        this.accountType = accountType;
        setMoney((double)0);

    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
