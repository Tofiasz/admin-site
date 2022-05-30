package pl.gorczynski.admin.model.shop.cart;

import lombok.Getter;
import lombok.Setter;
import pl.gorczynski.admin.model.shop.product.Product;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(unique = true, nullable = false)
    private Integer id;
    @ManyToOne
    private Product product;
    private Integer quantity;
}
