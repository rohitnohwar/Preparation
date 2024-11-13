package VendingMachice;

import VendingMachice.Product.Chocolate;
import VendingMachice.Product.ProductInterface;
import VendingMachice.Product.Wafer;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    Map<String, ProductInterface> m;

    public VendingMachine() {
        m = new HashMap<>();
        ProductInterface chococlate = new Chocolate(10);
        m.put("Chocolate", chococlate);

        ProductInterface wafer = new Wafer(5);
        m.put("Wafer", wafer);
    }

    public void selectItem(String item, int input) {
        ProductInterface productInterface = m.get(item);

        productInterface.calculateChange(input);
    }
}
