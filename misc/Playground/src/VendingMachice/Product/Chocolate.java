package VendingMachice.Product;

public class Chocolate extends ProductInterface{
    int cost;
    public Chocolate(int cost) {
        this.cost = cost;
    }
    @Override
    public int calculateChange(int input) {
        System.out.println("Your change is:- " +(input - cost));
        return input - cost;
    }
}
