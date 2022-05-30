package pl.gorczynski.admin.repository.shop.order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.gorczynski.admin.model.shop.order.Order;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

    @Query(value = "SELECT COUNT(shop_order.*) \n" +
            "FROM shop_order \n" +
            "WHERE order_date BETWEEN ?1 AND ?2\n",
            nativeQuery = true)
    Integer countAllOrdersBetweenDatesRange(final Date fromDate, final Date toDate);

    @Query(value = "SELECT SUM(total_price) \n" +
            "FROM shop_order \n" +
            "WHERE order_date BETWEEN ?1 AND ?2\n",
            nativeQuery = true)
    Integer getEarningsCurrentYear(final Date fromDate, final Date toDate);
    @Query(value = "SELECT first_name AS firstName, \n" +
            "email_address AS emailAddress,COUNT(customer_id)\n" +
            "AS orders\n" +
            "FROM shop_order\n" +
            "FULL OUTER JOIN customer ON shop_order.customer_id = customer.id\n" +
            "GROUP BY customer.first_name, customer.last_name,  customer.email_address\n" +
            "ORDER BY orders\n" +
            "DESC LIMIT 5",
            nativeQuery = true)
    List<TopBuyers> findTop5Buyers();
    @Query(value = "SELECT SUM(total_price)\n" +
            "FROM shop_order\n" +
            "WHERE order_date BETWEEN ?1 AND ?2",
            nativeQuery = true)
    Integer getEarningsBetweenDates(final Date fromDate, final Date toDate);
    Page<Order> findAll(final Pageable pageable);
}
