package rohit.nohwar.lld.patterns.creationalpatterns.singleton.initializationholdersingleton;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        LazyRegisteryWithSubClass registry1 = LazyRegisteryWithSubClass.getInstance();
        LazyRegisteryWithSubClass registry2 = LazyRegisteryWithSubClass.getInstance();

        System.out.println(registry1 == registry2);
    }
}