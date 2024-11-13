package VendingMachice;

public class Main {
    public static void main(String args[]) {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.selectItem("Wafer", 15);
        vendingMachine.selectItem("Chocolate", 28);
    }
}
