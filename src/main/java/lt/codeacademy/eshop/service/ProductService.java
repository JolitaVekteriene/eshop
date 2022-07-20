package lt.codeacademy.eshop.service;


import lt.codeacademy.eshop.dto.Product;
//import lt.codeacademy.eshop.entity.ProductEntity;
//import lt.codeacademy.eshop.exception.ProductNotExistException;
import lt.codeacademy.eshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(Product product) {
        product.setId(UUID.randomUUID());
        productRepository.saveProduct(product);
    }

    public List<Product> getProducts() {
        return productRepository.getProducts().stream()
                .map(Product::convert)
                .toList();
    }

    public Product getProduct(UUID id) {
        return productRepository.getProduct(id);
//        return productRepository.findById(id)
//                .map(Product::convert)
//                .orElseThrow(() -> new ProductNotExistException(id));
    }

    public void updateProduct(Product product) {
        productRepository.saveProduct(product);
//        productRepository.save(ProductEntity.convert(product));
    }

    public void delete(UUID id) {
        productRepository.delete(id);
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.getProductsByCategory(category).stream()
                .map(Product::convert)
                .toList();
    }
}