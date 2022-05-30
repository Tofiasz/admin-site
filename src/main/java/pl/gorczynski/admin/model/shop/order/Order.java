package pl.gorczynski.admin.model.shop.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.gorczynski.admin.model.shop.product.Product;
import pl.gorczynski.admin.model.shop.user.Customer;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "shop_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(unique = true, nullable = false)
    private Integer id;
    private Integer orderNumber;
    private Date orderDate;
    private Date shipDate;
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;
    @ManyToMany
    private List<Product> productList;
    private Double totalPrice;
    private Double discount;
    @ManyToOne
    private Payment payment;
    @ManyToOne
    private Shipper shipper;
    private String transactStatus;
    private Boolean paid;
    private Date paymentDate;
}
