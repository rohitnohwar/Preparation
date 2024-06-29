package com;

import com.transaction.manager.TransactionType;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private User payer;
    int amount;
    TransactionType transactionType;
    private List<Split> owers;

    public Transaction(User payer, List<Split> owers, int amount) {
        this.payer = payer;
        this.owers = owers;
        this.amount = amount;
    }

    public Transaction() {
        owers = new ArrayList<>();
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public User getPayer() {
        return payer;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }

    public List<Split> getOwers() {
        return owers;
    }

    public void setOwers(List<Split> owers) {
        this.owers = owers;
    }
}
