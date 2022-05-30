package pl.gorczynski.admin.repository.shop.order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.gorczynski.admin.model.shop.order.Shipper;

import java.util.List;

@Repository
public interface ShipperRepository extends CrudRepository<Shipper, Integer> {

    List<Shipper> findAll();
}
