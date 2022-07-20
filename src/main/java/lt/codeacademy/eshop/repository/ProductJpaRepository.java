package lt.codeacademy.eshop.repository;

import lt.codeacademy.eshop.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, UUID> {
   List<ProductEntity> findAllByCategory(String category);
}
