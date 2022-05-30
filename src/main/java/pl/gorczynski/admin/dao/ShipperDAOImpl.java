package pl.gorczynski.admin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gorczynski.admin.model.shop.order.Shipper;
import pl.gorczynski.admin.service.shop.order.ShipperService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ShipperDAOImpl implements DAO<Shipper> {

    private final ShipperService shipperService;

    @Autowired
    public ShipperDAOImpl(final ShipperService shipperService) {
        this.shipperService = shipperService;
    }

    @Override
    public Optional<Shipper> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Shipper> getAll() {
        return null;
    }

    @Override
    public void save(final Shipper shipper) {
        shipperService.save(shipper);
    }

    @Override
    public void update(Shipper shipper, String[] params) {

    }

    @Override
    public void delete(Shipper shipper) {

    }

    public void saveShippersList() {
        getShipperList().forEach(this::save);
    }

    public List<Shipper> getShipperList() {
        List<Shipper> shipperList = new ArrayList<>();
        shipperList.add(new Shipper(100, "DHL"));
        shipperList.add(new Shipper(101, "DPD"));
        shipperList.add(new Shipper(102, "InPost"));

        return shipperList;
    }
}
