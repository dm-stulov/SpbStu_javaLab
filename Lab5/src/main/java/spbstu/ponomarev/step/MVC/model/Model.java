package spbstu.ponomarev.step.MVC.model;

import spbstu.ponomarev.step.MVC.model.component.Product;
import spbstu.ponomarev.step.MVC.model.repository.Repository;
import spbstu.ponomarev.step.MVC.model.repository.RepositoryFactory;
import spbstu.ponomarev.step.MVC.model.repository.specification.ProductEmptySpecification;
import spbstu.ponomarev.step.MVC.model.repository.specification.Specification;

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

  public Product getProduct() {
    return product;
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

  private void clearTable() throws Exception {
    var deleteAll = new ProductEmptySpecification();

    repository.delete(deleteAll);
  }
}
