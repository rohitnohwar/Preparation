package rohit.nohwar.lld.patterns.creationalpatterns.singleton.eagersingleton;

import rohit.nohwar.lld.patterns.creationalpatterns.singleton.eagersingleton.EagerRegistry;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        EagerRegistry registry1 = EagerRegistry.getInstance();
        EagerRegistry registry2 = EagerRegistry.getInstance();

        System.out.println(registry1 == registry2);
    }
}