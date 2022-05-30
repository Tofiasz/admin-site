package pl.gorczynski.admin.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.gorczynski.admin.model.shop.product.Product;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ProductReviewDTO {

    private Integer id;
    private Product product;
    private String reviewTitle;
    private Integer reviewRating;
    private Date publishedDate;
    private String review;
}
