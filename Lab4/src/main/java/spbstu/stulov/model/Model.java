package spbstu.stulov.model;

import spbstu.stulov.model.component.Product;
import spbstu.stulov.model.repository.Repository;
import spbstu.stulov.model.repository.specification.ProductEmptySpecification;
import spbstu.stulov.model.repository.specification.Specification;
import spbstu.stulov.model.repository.RepositoryFactory;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private RepositoryFactory repositoryFactory;
    private Repository repository;

    private Product product;
    private List<Product> products;

    public Model() throws Exception {
        repositoryFactory = new RepositoryFactory();
        repository = repositoryFactory.getRepository(RepositoryFactory.REPOSITORY_TYPE.PRODUCT_SQL);
        products = new ArrayList<>();

        clearTable();
    }

    public void addProduct(Product product) {
        try {
            repository.add(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeProduct(Specification specification) {
        try {
            repository.delete(specification);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(Specification specification) {
        try {
            repository.update(specification);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadProduct(Specification specification) {
        product = null;
        try {
            product = (Product) repository.get(specification);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadProductList(Specification specification) {
        try {
            products = (List<Product>) repository.getList(specification);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProduct() {
        return product;
    }

    private void clearTable() throws Exception {
        var deleteAll = new ProductEmptySpecification();

        repository.delete(deleteAll);
    }
}
