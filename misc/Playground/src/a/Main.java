package a;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Class a = new Class1(8);
        b(a);
        a.k();
//        System.out.println(a.i);
//        a.k();
//        List<Integer> e = new ArrayList<>();
//        e.add("j");
//        System.out.println(e.get(0));
    }

    private static void b(Class a) {
        a.i = 4;
        System.out.println(a.i);
    }
}