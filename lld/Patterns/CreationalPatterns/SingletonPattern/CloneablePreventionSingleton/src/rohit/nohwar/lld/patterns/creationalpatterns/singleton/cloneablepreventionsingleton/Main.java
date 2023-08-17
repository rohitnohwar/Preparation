package rohit.nohwar.lld.patterns.creationalpatterns.singleton.cloneablepreventionsingleton;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        CloneablePreventionSingleton instance1 = CloneablePreventionSingleton.getInstance();

        CloneablePreventionSingleton instance2 = CloneablePreventionSingleton.getInstance();

        // Throws exception as we wanted it not to clone
        CloneablePreventionSingleton instance3 = instance1.clone();
    }
}