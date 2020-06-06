package spbstu.stulov.model.component;

import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

public class Product {
    private String id;

    private String title;
    private double cost;

    public Product(String title, double cost) {
        this.title = title;
        this.cost = cost;

        generateId();
    }

    public Product(String id, String title, double cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    private void generateId() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Title: %1$s, Cost: %2$s", this.title, this.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.title, this.cost);
    }

    @Override
    public boolean equals(Object obj) {
        Product product = (Product) obj;

        return product.id.equals(this.id)
                && product.title.equals(this.title);
    }
}
