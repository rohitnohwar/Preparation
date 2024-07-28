package com.transaction.manager;

import com.Transaction;
import com.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class TransactionManager {
    public abstract void addTransaction(List<Transaction> transactions, String[] commands, Map<String, User> users);
}
