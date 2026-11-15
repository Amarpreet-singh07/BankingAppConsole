package services;
import java.util.*;
import domain.Account;

public interface BankServices
{
    String openAccount(String name,String accountType,Double intialBalance,String mobileNumber,Integer age,String email);
    List<Account> listOfAccounts();
}
