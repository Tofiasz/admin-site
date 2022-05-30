package pl.gorczynski.admin.service.shop.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gorczynski.admin.model.shop.order.Shipper;
import pl.gorczynski.admin.repository.shop.order.ShipperRepository;

import java.util.List;

@Service
public class ShipperService {

    private final ShipperRepository shipperRepository;

    @Autowired
    public ShipperService(final ShipperRepository shipperRepository) {
        this.shipperRepository = shipperRepository;
    }

    public void save(final Shipper shipper) {
        shipperRepository.save(shipper);
    }

    public List<Shipper> getAllShippersList() {
        return shipperRepository.findAll();
    }

    public Integer getNumberOfShippers() {
        return Math.toIntExact(shipperRepository.count());
    }
}
