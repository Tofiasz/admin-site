package pl.gorczynski.admin.repository.shop.order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.gorczynski.admin.model.shop.order.Payment;

import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {

    List<Payment> findAll();
}
