package rohit.nohwar.lld.behavioralpatterns.iteratorpattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Container container = new ColorContainer();

        for (Iterator it = container.getIterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }
}