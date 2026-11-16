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

    @Override
    public void withdrawMoney(String accountNumber, Double amount, String note) {
        Account accountobj = accountRepos.getAccountObject(accountNumber)
                .orElseThrow(()-> new RuntimeException("Invalid Account " + accountNumber));
        if(accountobj.getMoney().compareTo(amount) < 0)
        {
            throw new RuntimeException("Amount is not efficient");
        }
        else
        {
            accountobj.setMoney(accountobj.getMoney() - amount);
            Transaction transaction = new Transaction(accountNumber,UUID.randomUUID().toString(),TransactionType.WIDTHDRAW,amount,LocalDateTime.now(),note);
            transactionRepos.enterTransaction(transaction);
        }

    }

    @Override
    public void transferAmount(String fromAcc, String toAcc, Double amount, String note)
    {
       Account fromAccount = accountRepos.getAccountObject(fromAcc).orElseThrow(()-> new RuntimeException("Not valid fromAccount : " + fromAcc));
       Account toAccount = accountRepos.getAccountObject(toAcc).orElseThrow(()-> new RuntimeException("Not valid toAccount : " + toAcc));

       if(fromAccount.getMoney().compareTo(amount)<0)
       {
           throw new RuntimeException("Not sufficient balance");

       }
       fromAccount.setMoney(fromAccount.getMoney() - amount);
       toAccount.setMoney(toAccount.getMoney() - amount);

       Transaction fromTransaction = new Transaction(fromAcc,UUID.randomUUID().toString(),TransactionType.TRANSACTION_OUT,amount,LocalDateTime.now(),note);
       Transaction toTransaction = new Transaction(toAcc,UUID.randomUUID().toString(),TransactionType.TRANSACTION_IN,amount,LocalDateTime.now(),note);

       transactionRepos.enterTransaction(fromTransaction);
       transactionRepos.enterTransaction(toTransaction);

    }

    private String getAccountNumber()
    {
        Integer totalAccounts = accountRepos.gettotalAccounts() + 1;
        return  String.format("AC%06d",totalAccounts);
    }
}
