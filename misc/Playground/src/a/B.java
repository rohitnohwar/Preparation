package a;

public interface B {
    default void a1() {
        a2();
    }

    default void a2() {
        System.out.println("Inside B");
    }
}
