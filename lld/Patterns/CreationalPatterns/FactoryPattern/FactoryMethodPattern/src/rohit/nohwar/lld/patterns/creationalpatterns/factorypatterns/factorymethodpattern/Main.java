// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
package rohit.nohwar.lld.patterns.creationalpatterns.factorypatterns.factorymethodpattern;
public class Main {
    public static void main(String[] args) {
        AbstractMessageCreator jsonMessageCreator = new JsonMessageCreator();
        AbstractMessageCreator textMessageCreator = new TextMessageCreator();

        System.out.println(jsonMessageCreator.getMessage());
        System.out.println(textMessageCreator.getMessage());
    }
}