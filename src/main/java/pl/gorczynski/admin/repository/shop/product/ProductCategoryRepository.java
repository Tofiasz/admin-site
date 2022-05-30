package pl.gorczynski.admin.repository.shop.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.gorczynski.admin.model.shop.product.ProductCategory;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Integer> {

    List<ProductCategory> findAll();
    Page<ProductCategory> findAll(final Pageable pageable);
    @Query(value = "SELECT DISTINCT product_category.* \n" +
            "FROM product_category \n" +
            "FULL OUTER JOIN category ON product_category.category_id = category.id\n" +
            "WHERE lower(product_category.title) LIKE lower(concat('%', :searchFor,'%'))\n" +
            "OR lower(product_category.meta_title) LIKE lower(concat('%', :searchFor,'%'))\n" +
            "OR lower(product_category.content) LIKE lower(concat('%', :searchFor,'%'))\n" +
            "OR lower(category.title) LIKE lower(concat('%', :searchFor,'%'))\n",
    nativeQuery = true)
    List<ProductCategory> findAll(@Param("searchFor") final String searchFor);
}
