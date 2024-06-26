package com;

import java.util.List;

public class Group {
    private List<User> users;

    private List<Transaction> transactions;

    public Group(List<User> users, List<Transaction> transactions) {
        this.users = users;
        this.transactions = transactions;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
