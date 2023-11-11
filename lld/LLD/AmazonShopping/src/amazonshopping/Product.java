package amazonshopping;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private Category category;

    private List<Integer> ratingsList;
    
    private User ownerSelling;
    
    private int cost;

    private int ratings;
    private int averageRating;

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Integer> getRatingsList() {
        return ratingsList;
    }

    public void addRating(Integer rating) {
        this.ratingsList.add(rating);
        ratings += rating;
        averageRating = ratings / ratingsList.size();
    }

    public User getOwnerSelling() {
        return ownerSelling;
    }

    public void setOwnerSelling(User ownerSelling) {
        this.ownerSelling = ownerSelling;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Product(String name, Category category, User ownerSelling, int cost) {
        this.name = name;
        this.category = category;
        this.ratingsList = new ArrayList<>();
        this.ownerSelling = ownerSelling;
        this.cost = cost;
    }
}
