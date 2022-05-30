package pl.gorczynski.admin.mapper.order;

import org.springframework.stereotype.Component;
import pl.gorczynski.admin.dto.order.ShipperDTO;
import pl.gorczynski.admin.model.shop.order.Shipper;

@Component
public class ShipperMapper {

    public ShipperDTO toShipperDTO(final Shipper shipper) {
        return new ShipperDTO(shipper.getId(),
                shipper.getShipperId(),
                shipper.getCompanyName());
    }

    public Shipper toShipper(final ShipperDTO shipperDTO) {
        return new Shipper(shipperDTO.getId(),
                shipperDTO.getShipperId(),
                shipperDTO.getCompanyName());
    }
}
