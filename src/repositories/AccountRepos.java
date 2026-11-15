package repositories;

import domain.Account;

import javax.swing.text.html.Option;
import java.util.*;

public class AccountRepos
{
    private final Map<String, Account> accountRepos = new HashMap<>();

    public  void saveAccount(Account account)
    {
        accountRepos.put(account.getAccountNumber(),account);
    }

    public Integer gettotalAccounts()
    {
        return accountRepos.size();
    }

    public List<Account> getListOfAccounts()
    {
        return new ArrayList<>(accountRepos.values());
    }

    public Optional<Account> getAccountObject(String accountNum)
    {
        return Optional.ofNullable(accountRepos.get(accountNum));
    }
}
