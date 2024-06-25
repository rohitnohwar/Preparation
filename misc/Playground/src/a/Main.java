package a;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        int[] s = new int[]{1};
//        Helper helper = new Helper();
//        helper.s(s);
//        System.out.println(s[0]);
//
//        Class1<Integer> c = new Class1<>();
//        Class1 d = new Class1();

//        String ss = null;
//        Integer i = Integer.parseInt(ss);
//        Class1 a = new Class1();
//        Class1 b = a;
//
//        a.b();


        Class<Integer> a = new Class<>(2);
        Class<Integer> b = new Class<>(2);

        System.out.println(a.equals(b));
    }
}