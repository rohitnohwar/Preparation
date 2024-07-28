package amazonshopping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Catalog {
    private static Map<Category, Set<Product>> byCategory;
    private static Map<String, Set<Product>> byName;

    private static Catalog catalog;

    private static final Lock lock = new ReentrantLock();

    private Catalog() {

    }

    public Set<Product> searchByName(String name) {
        return byName.get(name);
    }

    public void addProduct(Product product) {
        Set<Product> listByName = byName.get(product.getName());
        listByName.add(product);

        Set<Product> listByCategory = byCategory.get(product.getName());
        listByCategory.add(product);
    }

    public void removeProduct(Order order) {
        for (Map.Entry<String, Set<Product>> name: byName.entrySet()) {
            for (Product product: name.getValue()) {
                if (order.getProducts().contains(product)) {
                    byName.get(name.getValue().remove(product));
                }
            }
        }

        for (Map.Entry<Category, Set<Product>> category: byCategory.entrySet()) {
            for (Product product: category.getValue()) {
                if (order.getProducts().contains(product)) {
                    byName.get(category.getValue().remove(product));
                }
            }
        }
//        List<Product> listByName = byName.get(product.getName());
//        listByName.add(product);
//
//        List<Product> listByCategory = byCategory.get(product.getName());
//        listByCategory.add(product);
    }

    public Set<Product> searchByCategory(Category category) {
        return byCategory.get(category);
    }

    public static Catalog getCatalog() {
        if (catalog == null) {
            lock.lock();
            if (catalog == null) {
                byCategory = new HashMap<>();
                byName = new HashMap<>();
                catalog = new Catalog();
            }
            lock.unlock();
        }

        return catalog;
    }
}
