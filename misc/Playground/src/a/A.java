package a;

public class A implements B {
    class I {
        private int a;
    }

    A() {
        I i = new I();
        i.a = 3;
    }

    public void a1() {
        B.super.a1();
    }

    public void a2() {
        System.out.println("Inside A");
    }
}
