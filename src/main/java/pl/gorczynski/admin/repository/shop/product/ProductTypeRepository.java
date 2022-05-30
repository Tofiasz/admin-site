package pl.gorczynski.admin.repository.shop.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.gorczynski.admin.model.shop.product.ProductType;

import java.util.List;

@Repository
public interface ProductTypeRepository extends CrudRepository<ProductType, Integer> {

    List<ProductType> findAll();
    Page<ProductType> findAll(final Pageable pageable);
    @Query(value = "SELECT DISTINCT product_type.* \n" +
            "FROM product_type \n" +
            "FULL OUTER JOIN product_category ON product_type.product_category_id  = product_category.id\n" +
            "FULL OUTER JOIN category ON product_category.category_id = category.id\n" +
            "WHERE lower(product_type.title) LIKE lower(concat('%', :searchFor,'%'))\n" +
            "OR lower(product_type.meta_title) LIKE lower(concat('%', :searchFor,'%'))\n" +
            "OR lower(product_type.content) LIKE lower(concat('%', :searchFor,'%'))\n" +
            "OR lower(product_category.title) LIKE lower(concat('%', :searchFor,'%'))\n" +
            "OR lower(category.title) LIKE lower(concat('%', :searchFor,'%'))\n",
    nativeQuery = true)
    List<ProductType> findAll(@Param("searchFor") final String searchFor);

}
