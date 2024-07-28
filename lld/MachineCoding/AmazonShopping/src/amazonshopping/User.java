package amazonshopping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private String name;

    private boolean isRegistered;

    private Set<Product> cart;

    private List<Product> toSell;

    private Set<Order> orders;

    private int balance;

    public User(String name, boolean isRegistered) {
        this.name = name;
        this.isRegistered = isRegistered;
        this.cart = new HashSet<>();
        this.toSell = new ArrayList<>();
        this.orders = new HashSet<>();
        this.balance = 0;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance += balance;
    }

    public Set<Product> searchCatalogByName(String name) {
        return Catalog.getCatalog().searchByName(name);
    }

    public Set<Product> searchCatalogByCategory(Category category) {
        return Catalog.getCatalog().searchByCategory(category);
    }

    public void placeOrder() {
        Order order = new Order(cart, this);
        this.orders.add(order);
        this.setCart(new HashSet<>());
    }

    public void cancelOrder(Order order) {
        if (this.orders.contains(order) && order.getOrderStatus() != OrderStatus.SHIPPED) {
            this.orders.remove(order);
            order.cancelOrder();
            order = null;
        }
    }

    public void addToSell(Product product) {
        this.toSell.add(product);
        Catalog.getCatalog().addProduct(product);
    }

    public void removeFromCart(Product product) {
        if (cart.contains(product)) {
            cart.remove(product);
        }
    }

    public void notify(String notified) {
        System.out.println(notified);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public Set<Product> getCart() {
        return cart;
    }

    public void setCart(Set<Product> cart) {
        this.cart = cart;
    }

    public List<Product> getToSell() {
        return toSell;
    }

    public void setToSell(List<Product> toSell) {
        this.toSell = toSell;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
