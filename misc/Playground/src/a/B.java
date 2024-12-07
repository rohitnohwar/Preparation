package a;

public interface B {
    default public void a1() {
        a2();
    }

    public default void a2() {
        System.out.println("Inside B");
    }
}
