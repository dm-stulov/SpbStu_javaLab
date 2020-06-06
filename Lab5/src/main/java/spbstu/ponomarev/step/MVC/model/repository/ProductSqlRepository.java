package spbstu.ponomarev.step.MVC.model.repository;

import spbstu.ponomarev.step.MVC.model.repository.specification.Specification;
import spbstu.ponomarev.step.MVC.model.component.Product;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ProductSqlRepository implements Repository<Product> {

  private Connection connection;

  private final String INSERT = "INSERT INTO lab5_product_table (prodid, title, cost) VALUES (?, ?, ?)";
  private final String DELETE = "DELETE FROM lab5_product_table";
  private final String SELECT = "SELECT * FROM lab5_product_table";
  private final String UPDATE = "UPDATE lab5_product_table";

  public ProductSqlRepository(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void add(Product product) throws Exception {
    var statement = connection.prepareStatement(INSERT);

    statement.setString(1, product.getId());
    statement.setString(2, product.getTitle());
    statement.setDouble(3, product.getCost());

    statement.execute();

    statement.close();
  }

  @Override
  public void delete(Specification specification) throws Exception {
    var statement = connection.prepareStatement(DELETE + " " + specification.getSpecification());

    statement.execute();

    statement.close();
  }

  @Override
  public void update(Specification specification) throws Exception {
    var statement = connection.prepareStatement(UPDATE + " " + specification.getSpecification());

    statement.execute();

    statement.close();
  }

  @Override
  public Product get(Specification specification) throws Exception {
    var statement = connection.prepareStatement(SELECT + " " + specification.getSpecification());

    var resultSet = statement.executeQuery();

    Product product = null;

    if (resultSet.next()) {
      product = new Product(
          resultSet.getString("prodid"),
          resultSet.getString("title"),
          resultSet.getDouble("cost")
      );
    }

    resultSet.close();
    statement.close();

    return product;
  }

  @Override
  public List<Product> getList(Specification specification) throws Exception {
    final List<Product> products = new ArrayList<>();

    var statement = connection.prepareStatement(SELECT + " " + specification.getSpecification());

    var resultSet = statement.executeQuery();

    while (resultSet.next()) {
      var product = new Product(
          resultSet.getString("prodid"),
          resultSet.getString("title"),
          resultSet.getDouble("cost")
      );

      products.add(product);
    }

    resultSet.close();
    statement.close();

    return products;
  }
}
