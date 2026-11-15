package repositories;

import domain.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
