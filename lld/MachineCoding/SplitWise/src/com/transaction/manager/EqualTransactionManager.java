package com.transaction.manager;

import com.Split;
import com.Transaction;
import com.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class EqualTransactionManager extends TransactionManager{
    public void addTransaction(List<Transaction> transactions, String[] commands, Map<String, User> users) {
        int amount = Integer.parseInt(commands[2]);
        int numberOfUser = Integer.parseInt(commands[3]);
        int amountPerPerson = amount / numberOfUser;
        String payer = commands[4];

        Transaction transaction = new Transaction();
        for (int i = 5; i < numberOfUser + 5; i++) {
            String thatUser = commands[i];
            if (thatUser.equals(payer)) {
                transaction.setPayer(users.get(thatUser));
            }
            else {
                Split split = new Split();
                split.setUser(users.get(thatUser));
                split.setSplitAmount(amountPerPerson);
                transaction.getOwers().add(split);
            }
        }

        transactions.add(transaction);
    }
}
