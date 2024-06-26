package com;

import java.util.*;

public class Driver {
    Map<String, Group> groups;

    public Driver() {
        groups = new HashMap<>();
    }

    public List<Transaction> getGroupTransactions(String groupId) {
        return groups.get(groupId).getTransactions();
    }

    private Map<String, Integer> getGroupBalance(String groupId) {
        List<Transaction> transactions = groups.get(groupId).getTransactions();
        Map<String, Integer> balance = new HashMap<>();

        for (Transaction transaction: transactions) {
            if (!balance.containsKey(transaction.getPayer().getUserId())) balance.put(transaction.getPayer().getUserId(), 0);
//            balance.put(transaction.getPayer().getUserId(), balance.get(transaction.getPayer().getUserId()) + transaction.getAmount());

            for (Split split: transaction.getOwers()) {
                if (!balance.containsKey(split.getUser().getUserId())) balance.put(split.getUser().getUserId(), 0);
                balance.put(split.getUser().getUserId(), balance.get(split.getUser().getUserId()) - split.getSplitAmount());
                balance.put(transaction.getPayer().getUserId(), balance.get(transaction.getPayer().getUserId()) + split.getSplitAmount());
            }
        }

//        for (Map.Entry<String, Integer> m: balance.entrySet()) {
//            System.out.println(m.getKey() + ", " + m.getValue());
//        }

        return balance;
    }

    public Map<String, Map<String, Integer>> getGroupOwes(String groupId) {
        Map<String, Integer> balanceMap = this.getGroupBalance(groupId);

        List<Balance> balanceList = new ArrayList<>();
        for (Map.Entry<String, Integer> balanceMapElement: balanceMap.entrySet()) {
            String userId = balanceMapElement.getKey();
            Integer amount = balanceMapElement.getValue();

            Balance balance = new Balance(userId, amount);
            balanceList.add(balance);
        }


        balanceList.sort((a, b) -> a.getBalance() - b.getBalance());

        for (Balance b: balanceList) {
            System.out.println(b.getUserId()+" :- "+b.getBalance());
        }

        Map<String, Map<String, Integer>> owesHowMuch = new HashMap<>();
        for (int i = 0; i < balanceList.size() - 1; i++) {
            for (int j = i + 1; j < balanceList.size(); j++) {
                if (balanceList.get(i).getBalance() >= 0 || balanceList.get(j).getBalance() <= 0) continue;
                else {
                    int amount;
                    if (balanceList.get(j).getBalance() >= Math.abs(balanceList.get(i).getBalance())) {
                        amount = balanceList.get(i).getBalance();
                    }
                    else {
                        amount = balanceList.get(j).getBalance();
                    }

                    if (!owesHowMuch.containsKey(balanceList.get(i).getUserId())) owesHowMuch.put(balanceList.get(i).getUserId(), new HashMap<>());
                    owesHowMuch.get(balanceList.get(i).getUserId()).put(balanceList.get(j).getUserId(), Math.abs(amount));

                    balanceList.get(i).setBalance(balanceList.get(i).getBalance() + amount);
                    balanceList.get(j).setBalance(balanceList.get(j).getBalance() - amount);
                }
            }
        }

        return owesHowMuch;
    }




    public Map<String, Map<String, Integer>> getPersonalOwes(String groupId) {
        List<Transaction> transactions = groups.get(groupId).getTransactions();

        Map<String, Map<String, Integer>> owesHowMuch = new HashMap<>();

        for (Transaction transaction: transactions) {
            for (Split split: transaction.getOwers()) {
                if (!owesHowMuch.containsKey(split.getUser().getUserId())) owesHowMuch.put(split.getUser().getUserId(), new HashMap<>());
                if (!owesHowMuch.get(split.getUser().getUserId()).containsKey(transaction.getPayer().getUserId())) owesHowMuch.get(split.getUser().getUserId()).put(transaction.getPayer().getUserId(), 0);
                if (!owesHowMuch.containsKey(transaction.getPayer().getUserId())) owesHowMuch.put(transaction.getPayer().getUserId(), new HashMap<>());
                if (!owesHowMuch.get(transaction.getPayer().getUserId()).containsKey(split.getUser().getUserId())) owesHowMuch.get(transaction.getPayer().getUserId()).put(split.getUser().getUserId(), 0);

                owesHowMuch.get(split.getUser().getUserId()).put(transaction.getPayer().getUserId(), owesHowMuch.get(split.getUser().getUserId()).get(transaction.getPayer().getUserId()) - split.getSplitAmount());

                owesHowMuch.get(transaction.getPayer().getUserId()).put(split.getUser().getUserId(),  owesHowMuch.get(transaction.getPayer().getUserId()).get(split.getUser().getUserId()) + split.getSplitAmount() );
            }
        }

        return owesHowMuch;
    }
}

