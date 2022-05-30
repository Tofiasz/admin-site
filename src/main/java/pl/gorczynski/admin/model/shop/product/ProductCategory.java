package pl.gorczynski.admin.model.shop.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(unique = true, nullable = false)
    private Integer id;

    private String title;

    private String metaTitle;

    private String content;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;

    public ProductCategory(final String title,
                           final String metaTitle,
                           final String content,
                           final Category category) {
        this.title = title;
        this.metaTitle = metaTitle;
        this.content = content;
        this.category = category;
    }

    public ProductCategory(final Integer id) {
        this.id = id;
    }
}
