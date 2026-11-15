package services.services.impl;

import domain.Account;
import repositories.AccountRepos;
import services.BankServices;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BankConsoleServicesImplementation implements BankServices
{
    final AccountRepos accountRepos = new AccountRepos();
    @Override
    public String openAccount(String name, String accountType, Double intialBalance, String mobileNumber
            , Integer age, String email) {


        String accountNumber = getAccountNumber();

        String customerID = UUID.randomUUID().toString();

        Account account = new Account(accountNumber,customerID,(double)0,accountType);

        accountRepos.saveAccount(account);
        System.out.println("size " + accountRepos.gettotalAccounts());
        return accountNumber;



    }

    @Override
    public List<Account> listOfAccounts() {
        System.out.println("Size of list :" + accountRepos.gettotalAccounts());
        return accountRepos.getListOfAccounts().stream()
                .sorted(Comparator.comparing(Account::getAccountNumber))
                .collect(Collectors.toList());
    }

    private String getAccountNumber()
    {
        Integer totalAccounts = accountRepos.gettotalAccounts() + 1;
        return  String.format("AC%06d",totalAccounts);
    }
}
