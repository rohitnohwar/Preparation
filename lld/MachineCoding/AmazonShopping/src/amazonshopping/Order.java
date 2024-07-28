package amazonshopping;

import java.util.List;
import java.util.Set;

public class Order {
    Set<Product> products;

    private int cost;

    private OrderStatus orderStatus;

    private User buyer;

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Order(Set<Product> products, User buyer) {
        this.buyer = buyer;
        orderStatus = OrderStatus.PREPARING;
        this.products = products;
        for (Product product: this.products) {
            cost += product.getCost();
            product.getOwnerSelling().setBalance(product.getCost());
            buyer.setBalance(-product.getCost());
        }
    }

    public void cancelOrder() {
        for (Product product: this.products) {
            cost += product.getCost();
            product.getOwnerSelling().setBalance(-product.getCost());
            buyer.setBalance(product.getCost());
        }
    }

    public void changeShippingStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        if (this.orderStatus == OrderStatus.SHIPPED) {
            Catalog.getCatalog().removeProduct(this);
            buyer.notify("Order shipped");
        }
    }
}



enum OrderStatus {
    PREPARING,
    ONTHEWAY,
    SHIPPED
}
