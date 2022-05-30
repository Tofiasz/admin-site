package pl.gorczynski.admin.repository.shop.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.gorczynski.admin.model.shop.product.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

    List<Category> findAll();
    Page<Category> findAll(final Pageable pageable);
    void deleteById(final Integer categoryId);
    @Query(value = "SELECT * \n" +
            "FROM category \n" +
            "WHERE lower(category.title) LIKE lower(concat('%', :searchFor,'%'))\n" +
            "OR lower(category.meta_title) LIKE lower(concat('%', :searchFor,'%'))\n" +
            "OR lower(category.content) LIKE lower(concat('%', :searchFor,'%'))",
    nativeQuery = true)
    List<Category> findAll(@Param("searchFor") final String searchFor);
}
