package com;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Group {
    private Map<String, User> users;

    private List<Transaction> transactions;

    public Group(Map<String, User> users, List<Transaction> transactions) {
        this.users = users;
        this.transactions = transactions;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
