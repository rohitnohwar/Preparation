package a;

public interface Abstract {
    void a();
    default void  b() {
System.out.println("aak");
    }
}
