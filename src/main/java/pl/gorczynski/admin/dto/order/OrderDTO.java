package pl.gorczynski.admin.dto.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.gorczynski.admin.dto.product.ProductDTO;
import pl.gorczynski.admin.dto.user.CustomerDTO;
import pl.gorczynski.admin.model.shop.order.Payment;
import pl.gorczynski.admin.model.shop.order.Shipper;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Integer id;
    private Integer orderNumber;
    private Date orderDate;
    private Date shipDate;
    private CustomerDTO customerDTO;
    private List<ProductDTO> productDTOList;
    private Double totalPrice;
    private Double discount;
    private PaymentDTO paymentDTO;
    private ShipperDTO shipperDTO;
    private String transactStatus;
    private Boolean paid;
    private Date paymentDate;
}
