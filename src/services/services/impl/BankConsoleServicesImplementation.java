package services.services.impl;

import domain.Account;
import domain.Transaction;
import domain.TransactionType;
import repositories.AccountRepos;
import repositories.TransactionRepos;
import services.BankServices;

import javax.swing.tree.TreeNode;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BankConsoleServicesImplementation implements BankServices
{
    final AccountRepos accountRepos = new AccountRepos();
    final TransactionRepos transactionRepos = new TransactionRepos();
    @Override
    public String openAccount(String name, String accountType, Double intialBalance, String mobileNumber
            , Integer age, String email) {


        String accountNumber = getAccountNumber();

        String customerID = UUID.randomUUID().toString();

        Account account = new Account(accountNumber,customerID,accountType);

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

    @Override
    public void depositMoney(String accountNum, Double moneyDeposit, String note)
    {
        Account accountObj = accountRepos.getAccountObject(accountNum)
                .orElseThrow(() -> new RuntimeException("Invalid Account" + accountNum));

        accountObj.setMoney(accountObj.getMoney() + moneyDeposit);
        Transaction transaction = new Transaction(accountNum,UUID.randomUUID().toString(), TransactionType.DEPOSIT,moneyDeposit,LocalDateTime.now(),note);

        transactionRepos.enterTransaction(transaction);
    }

    private String getAccountNumber()
    {
        Integer totalAccounts = accountRepos.gettotalAccounts() + 1;
        return  String.format("AC%06d",totalAccounts);
    }
}
