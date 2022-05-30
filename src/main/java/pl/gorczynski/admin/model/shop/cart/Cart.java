package pl.gorczynski.admin.model.shop.cart;

import lombok.Getter;
import lombok.Setter;
import pl.gorczynski.admin.model.shop.user.Customer;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(unique = true, nullable = false)
    private Integer id;
    @OneToOne
    private Customer customer;
    @OneToMany
    private List<CartItem> cartItemList;
}
