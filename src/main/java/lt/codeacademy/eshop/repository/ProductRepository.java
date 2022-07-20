package lt.codeacademy.eshop.repository;

import lt.codeacademy.eshop.dto.Product;
import lt.codeacademy.eshop.entity.ProductEntity;
import lt.codeacademy.eshop.mapper.ProductMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

@Repository
public class ProductRepository {
    private final Map<UUID, Product> products;
    private final ProductJpaRepository productJpaRepository;


    public ProductRepository(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
        products = new HashMap<>();
    }

    public void saveProduct(Product product) {
        products.put(product.getId(), product);
    }

    public List<ProductEntity> getProducts() {
      return  productJpaRepository.findAll();

    }
    public  Product getProduct(UUID id) {
        return products.get(id);
    }

    public void delete(UUID id) {
        products.remove(id);
    }

    public List<ProductEntity> getProductsByCategory(String category) {
        return productJpaRepository.findAllByCategory(category);
    }

//        try {
//            Connection connection = dataSource.getConnection();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from PRODUCTS");
//        while (resultSet.next()) {
//            products.add(new Product(
//                    UUID.fromString(resultSet.getString("id")),
//                    resultSet.getNString("name"),
//                    resultSet.getNString("description"),
//                    resultSet.getNString("category"),
//                    resultSet.getInt("quantity"),
//                    resultSet.getBigDecimal("price")
//                    ));
//        }
//        }catch (Exception e) {
//            System.out.println(e);
//        }
//
//        return products;
//    }
}
