package pl.gorczynski.admin.model.shop.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(unique = true, nullable = false)
    private Integer id;

    private String title;
    private String metaTitle;
    private String content;

    public Category(final String title,
                    final String metaTitle,
                    final String content) {
        this.title = title;
        this.metaTitle = metaTitle;
        this.content = content;
    }
}
