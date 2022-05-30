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
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(unique = true, nullable = false)
    private Integer id;
    @NotNull
    @OneToOne
    private Product product;
    @NotNull
    private String reviewTitle;
    @NotNull
    private Integer reviewRating;
    @NotNull
    private Date publishedDate;
    @NotNull
    private String review;

    public ProductReview(final @NotNull Product product,
                         final @NotNull String reviewTitle,
                         final @NotNull Integer reviewRating,
                         final @NotNull Date publishedDate,
                         final @NotNull String review) {
        this.product = product;
        this.reviewTitle = reviewTitle;
        this.reviewRating = reviewRating;
        this.publishedDate = publishedDate;
        this.review = review;
    }
}
