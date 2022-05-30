package pl.gorczynski.admin.repository.shop.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.gorczynski.admin.model.shop.product.ProductImage;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductImageRepository extends CrudRepository<ProductImage, Integer> {

    List<ProductImage> findAll();
    Optional<ProductImage> findById(Integer id);
}
