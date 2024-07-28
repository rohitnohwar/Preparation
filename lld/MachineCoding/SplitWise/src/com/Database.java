package com;

import java.util.*;

public class Database {
    Map<String, Group> groups;

    public Database() {
        groups = new HashMap<>();
    }


    public List<Transaction> getTransactionsForAGroup(String groupId) {
        return groups.get(groupId).getTransactions();
    }

    public Map<String, User> getGroupUsers(String groupId) {

        return groups.get(groupId).getUsers();
    }
}

