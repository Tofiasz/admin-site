package pl.gorczynski.admin.mapper.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gorczynski.admin.dto.order.OrderDTO;
import pl.gorczynski.admin.mapper.product.ProductMapper;
import pl.gorczynski.admin.mapper.user.CustomerMapper;
import pl.gorczynski.admin.model.shop.order.Order;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    private final CustomerMapper customerMapper;
    private final ProductMapper productMapper;
    private final PaymentMapper paymentMapper;
    private final ShipperMapper shipperMapper;

    @Autowired
    public OrderMapper(final CustomerMapper customerMapper,
                       final ProductMapper productMapper,
                       final PaymentMapper paymentMapper,
                       final ShipperMapper shipperMapper) {
        this.customerMapper = customerMapper;
        this.productMapper = productMapper;
        this.paymentMapper = paymentMapper;
        this.shipperMapper = shipperMapper;
    }

    public OrderDTO toOrderDTO(final Order order) {
        return new OrderDTO(order.getId(),
                order.getOrderNumber(),
                order.getOrderDate(),
                order.getShipDate(),
                customerMapper.toCustomerDTO(order.getCustomer()),
                productMapper.toProductDTOList(order.getProductList()),
                order.getTotalPrice(),
                order.getDiscount(),
                paymentMapper.toPaymentDTO(order.getPayment()),
                shipperMapper.toShipperDTO(order.getShipper()),
                order.getTransactStatus(),
                order.getPaid(),
                order.getPaymentDate());
    }

    public List<OrderDTO> toOrderDTOList(final List<Order> orderList) {
        return orderList.stream()
                .map(this::toOrderDTO)
                .collect(Collectors.toList());
    }

    public Order toOrder(final OrderDTO orderDTO) {
        return new Order(orderDTO.getId(),
                orderDTO.getOrderNumber(),
                orderDTO.getOrderDate(),
                orderDTO.getShipDate(),
                customerMapper.toCustomer(orderDTO.getCustomerDTO()),
                productMapper.toProductList(orderDTO.getProductDTOList()),
                orderDTO.getTotalPrice(),
                orderDTO.getDiscount(),
                paymentMapper.toPayment(orderDTO.getPaymentDTO()),
                shipperMapper.toShipper(orderDTO.getShipperDTO()),
                orderDTO.getTransactStatus(),
                orderDTO.getPaid(),
                orderDTO.getPaymentDate());
    }

    public List<Order> toOrderList(final List<OrderDTO> orderDTOList) {
        return orderDTOList.stream()
                .map(this::toOrder)
                .collect(Collectors.toList());
    }
}
