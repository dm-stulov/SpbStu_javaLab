package spbstu.stulov.model.repository.specification;

import java.util.Locale;

public class ProductCostSpecification implements Specification {
    private double lowCost;
    private double highCost;

    public ProductCostSpecification(double lowCost, double highCost) {
        this.lowCost = lowCost;
        this.highCost = highCost;
    }

    @Override
    public String getSpecification() {
        return String.format(Locale.US, "WHERE cost BETWEEN '%1f' AND '%2f'", lowCost, highCost);
    }

    public double getLowCost() {
        return lowCost;
    }

    public double getHighCost() {
        return highCost;
    }
}
