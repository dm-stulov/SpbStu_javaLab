package spbstu.stulov.model.repository.specification;

import java.util.Locale;

public class ProductUpdateByCostSpecification implements Specification {
    private String title;
    private double newCost;

    public ProductUpdateByCostSpecification(String title, double newCost) {
        this.title = title;
        this.newCost = newCost;
    }

    @Override
    public String getSpecification() {
        return String.format(Locale.US, "SET cost = '%1f' WHERE title = '%2$s'", newCost, title);
    }

    public double getNewCost() {
        return newCost;
    }
}
