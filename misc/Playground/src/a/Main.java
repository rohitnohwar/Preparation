package a;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Class1<String, Integer> a = new Class1<>("h");

        k(a);
    }

    private static void k(Class1 c) {
        System.out.println(c.i);
    }
}