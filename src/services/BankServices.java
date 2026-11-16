package services;
import java.util.*;
import domain.Account;

public interface BankServices
{
    String openAccount(String name,String accountType,Double intialBalance,String mobileNumber,Integer age,String email);
    List<Account> listOfAccounts();

    void depositMoney(String accountNum, Double moneyDeposit, String note);

    void withdrawMoney(String accountNumber, Double amount, String note);

    void transferAmount(String fromAcc, String toAcc, Double amount, String note);
}
