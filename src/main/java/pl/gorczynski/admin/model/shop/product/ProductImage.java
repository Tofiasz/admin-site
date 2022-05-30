package pl.gorczynski.admin.model.shop.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(unique = true, nullable = false)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private Date uploadedAt;
    @Column(length = 16000000)
    @Basic(fetch = FetchType.LAZY)
    @NotNull
    private byte[] image;

    public ProductImage(final Integer id,
                        final @NotNull String name,
                        final byte[] image) {
        this.id = id;
        this.name = name;
        this.uploadedAt = new Date();
        this.image = image;
    }

    public ProductImage(final @NotNull String name,
                        final byte[] image) {
        this.name = name;
        this.uploadedAt = new Date();
        this.image = image;
    }
}
