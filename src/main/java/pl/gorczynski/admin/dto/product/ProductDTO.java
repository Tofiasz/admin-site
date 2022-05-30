package pl.gorczynski.admin.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Integer id;
    private String title;
    private String metaTitle;
    private String stockKeepingUnit;
    private String codeEAN;
    private Double price;
    private Double discount;
    private Double tax;
    private Integer quantity;
    private Boolean productAvailable;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    private Date updatedAt;
    private Date publishedAt;
    private Date saleStartAt;
    private Date saleEndsAt;
    private String content;
    private ProductCategoryDTO productCategoryDTO;
    private List<ProductReviewDTO> productReviewDTOList;
    private List<ProductImageDTO> productImageDTOList;
    private ProductTypeDTO productTypeDTO;
}
