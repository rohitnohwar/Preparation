package rohit.nohwar.lld.patterns.creationalpatterns.singleton.lazysingleton;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        LazyRegistry registry1 = LazyRegistry.getInstance();
        LazyRegistry registry2 = LazyRegistry.getInstance();

        System.out.println(registry1 == registry2);
    }
}