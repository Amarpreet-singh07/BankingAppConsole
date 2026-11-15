package repositories;

import domain.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionRepos {
    private final Map<String, List<Transaction>> transactionsRepos = new HashMap<>();

    public void enterTransaction(Transaction transaction)
    {
        // if list available then return else create a new one and return
        List<Transaction> transactionList = transactionsRepos.computeIfAbsent(transaction.getAccountNumber(),k -> new ArrayList<>());

        transactionsRepos.put(transaction.getAccountNumber(),transactionList);

    }
}
