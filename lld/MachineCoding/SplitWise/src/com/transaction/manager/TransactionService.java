package com.transaction.manager;

import com.Transaction;
import com.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TransactionService {
    public static void addTransaction(List<Transaction> transactions, String[] commands, Map<String, User> users) {
        String splitType = commands[1];
        TransactionManager transactionManager;

        switch (splitType) {
            case "EQUAL":
                transactionManager = new EqualTransactionManager();
                transactionManager.addTransaction(transactions, commands, users);
                break;
            case "EXACT":
                transactionManager = new ExactTransactionManager();
                transactionManager.addTransaction(transactions, commands, users);
                break;
            case "PERCENT":
                transactionManager = new PercentTransactionManager();
                transactionManager.addTransaction(transactions, commands, users);
                break;
            default:
                break;
        }
    }
}
