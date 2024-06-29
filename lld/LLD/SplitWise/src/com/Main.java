package com;

import com.transaction.manager.TransactionService;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        User u1 = new User("u1");
        User u2 = new User("u2");
        User u3 = new User("u3");
        User u4 = new User("u4");

        Split s1 = new Split(u2, 250);
        Split s2 = new Split(u3, 250);
        Split s3 = new Split(u4, 250);
        Transaction t1 = new Transaction(u1, new ArrayList<>(Arrays.asList(s1, s2, s3)), 1000);

        Group group = new Group(
                new HashMap<String, User>()
        {{
                    put("u1", u1);
                    put("u2", u2);
                    put("u3", u3);
                    put("u4", u4);
        }}
                , new ArrayList<>(
                Arrays.asList(t1)
        ));

        Split s4 = new Split(u2, 370);
        Split s5 = new Split(u3, 880);
        Transaction t2 = new Transaction(u1, new ArrayList<>(Arrays.asList(s4, s5)), 1250);

        group.getTransactions().add(t2);

        Split s6 = new Split(u1, 480);
        Split s7 = new Split(u2, 240);
        Split s8 = new Split(u3, 240);
        Transaction t3= new Transaction(u4, new ArrayList<>(Arrays.asList(s6, s7, s8)), 1200);

        group.getTransactions().add(t3);

        Driver driver = new Driver();
        driver.groups.put("1", group);

        Scanner sc = new Scanner(System.in);


        while (true) {
            String com = sc.nextLine();
            String[] command = com.split(" ");
            String commandType = command[0];

            switch (commandType) {
                case "SHOW":
                    Map<String, Map<String, Integer>> owesHowMuch;
                    if (command.length < 2) {
                        owesHowMuch = driver.getPersonalOwes("1", null);
                    }
                    else {
                        owesHowMuch = driver.getPersonalOwes("1", command[1]);
                        System.out.println(command[1]);
                    }

                    for (Map.Entry<String, Map<String, Integer>> owes : owesHowMuch.entrySet()) {
                        System.out.println(owes.getKey());

                        for (Map.Entry<String, Integer> owe : owes.getValue().entrySet()) {
                            System.out.println("---------------" + owe.getKey() + "  " + owe.getValue());
                        }
                    }
                    break;
                case "TRANSACTION":
                    List<Transaction> transactions = driver.getTransactionsForAGroup("1");
                    Map<String, User> users = driver.getGroupUsers("1");
                    TransactionService.addTransaction(transactions, command, users);
                    break;
                default:
                    break;
            }


//            Map<String, Map<String, Integer>> owesHowMuch = driver.getPersonalOwes("1", null);
//
//            for (Map.Entry<String, Map<String, Integer>> owes : owesHowMuch.entrySet()) {
//                System.out.println(owes.getKey());
//
//                for (Map.Entry<String, Integer> owe : owes.getValue().entrySet()) {
//                    System.out.println(owe.getValue());
//
//
//                }
//            }
//
//            owesHowMuch = driver.getGroupOwes("1");
//
//            for (Map.Entry<String, Map<String, Integer>> owes : owesHowMuch.entrySet()) {
//                System.out.println(owes.getKey());
//
//                for (Map.Entry<String, Integer> owe : owes.getValue().entrySet()) {
//                    System.out.println(owe.getKey() + ", " + owe.getValue());
//                }
//
//                System.out.println("---------------------------");
//            }

        }

    }
}