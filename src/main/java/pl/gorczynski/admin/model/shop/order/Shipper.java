package pl.gorczynski.admin.model.shop.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shipper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(unique = true, nullable = false)
    private Integer id;
    private Integer shipperId;
    private String companyName;

    public Shipper(final Integer shipperId,
                   final String companyName) {
        this.shipperId = shipperId;
        this.companyName = companyName;
    }
}
