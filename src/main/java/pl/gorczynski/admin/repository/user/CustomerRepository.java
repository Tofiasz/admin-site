package pl.gorczynski.admin.repository.user;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.gorczynski.admin.model.shop.user.Customer;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

    @NotNull
    Optional<Integer> findById(final @NotNull Customer customer);
    @NotNull Page<Customer> findAll(final @NotNull Pageable pageable);
    @Query(value = "SELECT DISTINCT customer.* \n" +
            "FROM customer \n" +
            "FULL OUTER JOIN address ON customer.address_id = address.id\n" +
            "WHERE lower(customer.login) LIKE lower(concat('%', :searchFor,'%'))\n" +
            "OR lower(customer.first_name) LIKE lower(concat('%', :searchFor,'%'))\n" +
            "OR lower(customer.last_name) LIKE lower(concat('%', :searchFor,'%'))\n" +
            "OR lower(customer.email_address) LIKE lower(concat('%', :searchFor,'%'))\n" +
            "OR lower(address.city) LIKE lower(concat('%', :searchFor,'%'))\n" +
            "OR lower(address.country) LIKE lower(concat('%', :searchFor,'%'))",
    nativeQuery = true)
    List<Customer> findAll(@Param("searchFor") final String searchFor);
}
