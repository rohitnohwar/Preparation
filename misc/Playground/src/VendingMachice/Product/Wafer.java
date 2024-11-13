package VendingMachice.Product;

public class Wafer extends ProductInterface{
    int cost;
    public Wafer(int cost) {
        this.cost = cost;
    }
    @Override
    public int calculateChange(int input) {
        System.out.println("Your change is:- " +(input - cost));
        return input - cost;
    }
}
