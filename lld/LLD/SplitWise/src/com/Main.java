package com;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        User u1 = new User("1");
        User u2 = new User("2");
        User u3 = new User("3");
        User u4 = new User("4");

        Split s1 = new Split(u2, 250);
        Split s2 = new Split(u3, 250);
        Split s3 = new Split(u4, 250);
        Transaction t1 = new Transaction(u1, new ArrayList<>(Arrays.asList(s1, s2, s3)), 1000);

        Group group = new Group(new ArrayList<>(Arrays.asList(u1, u2, u3, u4)), new ArrayList<>(
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

//        List<Transaction> t = driver.groups.get("1").getTransactions();
//        for (int i = 0; i < t.size(); i++) {
//            System.out.println(t.get(i).getPayer().getUserId());
//
//            for (int j = 0; j < t.get(i).getOwers().size(); j++) {
//                System.out.println(t.get(i).getOwers().get(j).getUser().getUserId());
//            }
//        }

        Map<String, Map<String, Integer>> owesHowMuch = driver.getPersonalOwes("1");

//        for (Map.Entry<String, Map<String, Integer>> owes: owesHowMuch.entrySet()) {
//            System.out.println(owes.getKey());
//
//            for (Map.Entry<String, Integer> owe: owes.getValue().entrySet()) {
//                System.out.println(owe.getValue());
//
//
//            }
//        }

        owesHowMuch = driver.getGroupOwes("1");

        for (Map.Entry<String, Map<String, Integer>> owes: owesHowMuch.entrySet()) {
            System.out.println(owes.getKey());

            for (Map.Entry<String, Integer> owe: owes.getValue().entrySet()) {
                System.out.println(owe.getKey() + ", " + owe.getValue());
            }

            System.out.println("---------------------------");
        }

    }
}