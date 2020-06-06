package spbstu.stulov.model.repository.specification;

public class ProductTitleSpecification implements Specification {
    private String title;

    public ProductTitleSpecification(String title) {
        this.title = title;
    }

    @Override
    public String getSpecification() {
        return String.format("WHERE title = '%1$s'", title);
    }
}
