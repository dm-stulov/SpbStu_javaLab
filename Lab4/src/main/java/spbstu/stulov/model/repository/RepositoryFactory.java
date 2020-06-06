package spbstu.stulov.model.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class RepositoryFactory {
    private final String URL = "jdbc:mysql://localhost:3306/lab5_product?useUnicode=true&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "sql12345";

    private Connection connection;

    public enum REPOSITORY_TYPE {
        PRODUCT_SQL
    }

    public RepositoryFactory() throws Exception {
        this.connection = getConnection();
    }

    public Repository getRepository(REPOSITORY_TYPE type) throws Exception {
        switch (type) {
            case PRODUCT_SQL:
                return (new ProductSqlRepository(connection));
            default:
                throw new Exception("Invalid REPOSITORY_TYPE");
        }
    }

    private Connection getConnection() throws Exception {
        Connection connection = DriverManager.getConnection(this.URL, this.USER, this.PASSWORD);

        return connection;
    }
}
