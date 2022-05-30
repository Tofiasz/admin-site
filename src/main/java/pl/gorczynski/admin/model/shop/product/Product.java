package pl.gorczynski.admin.model.shop.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(unique = true, nullable = false)
    private Integer id;
    @NotNull
    private String title;
    @NotNull
    private String metaTitle;
    @NotNull
    private String stockKeepingUnit;
    @NotNull
    private String codeEAN;
    @NotNull
    private Double price;
    private Double discount;
    @NotNull
    private Double tax;
    @NotNull
    private Integer quantity;
    @NotNull
    private Boolean productAvailable;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date createdAt;
    private Date updatedAt;
    private Date publishedAt;
    private Date saleStartAt;
    private Date saleEndsAt;
    @NotNull
    private String content;
    @NotNull
    @ManyToOne
    private ProductCategory productCategory;
    @OneToMany
    private List<ProductReview> productReviewList;
    @OneToMany(cascade=CascadeType.ALL)
    private List<ProductImage> productImageList;
    @ManyToOne
    private ProductType productType;

    public Product(@NotNull final String title,
                   @NotNull final String metaTitle,
                   @NotNull final String stockKeepingUnit,
                   @NotNull final String codeEAN,
                   @NotNull final Double price,
                   final Double discount,
                   @NotNull final Double tax,
                   @NotNull final Integer quantity,
                   @NotNull final Boolean productAvailable,
                   @NotNull final String content,
                   @NotNull final ProductCategory productCategory,
                   final List<ProductImage> productImageList) {
        this.title = title;
        this.metaTitle = metaTitle;
        this.stockKeepingUnit = stockKeepingUnit;
        this.codeEAN = codeEAN;
        this.price = price;
        this.discount = discount;
        this.tax = tax;
        this.quantity = quantity;
        this.productAvailable = productAvailable;
        this.createdAt = new Date();
        this.content = content;
        this.productCategory = productCategory;
        this.productImageList = productImageList;
    }

    public Product(final @NotNull String title,
                   final @NotNull String metaTitle,
                   final @NotNull String stockKeepingUnit,
                   final @NotNull Double price,
                   final @NotNull Double discount,
                   final @NotNull Double tax,
                   final @NotNull Integer quantity,
                   final @NotNull Boolean productAvailable,
                   final @NotNull Date createdAt,
                   final Date updatedAt,
                   final Date publishedAt,
                   final Date saleStartAt,
                   final Date saleEndsAt,
                   final @NotNull String content,
                   final @NotNull ProductCategory productCategory,
                   final List<ProductReview> productReviewList,
                   final List<ProductImage> productImageList) {
        this.title = title;
        this.metaTitle = metaTitle;
        this.stockKeepingUnit = stockKeepingUnit;
        this.price = price;
        this.discount = discount;
        this.tax = tax;
        this.quantity = quantity;
        this.productAvailable = productAvailable;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.publishedAt = publishedAt;
        this.saleStartAt = saleStartAt;
        this.saleEndsAt = saleEndsAt;
        this.content = content;
        this.productCategory = productCategory;
        this.productReviewList = productReviewList;
        this.productImageList = productImageList;
    }
}
