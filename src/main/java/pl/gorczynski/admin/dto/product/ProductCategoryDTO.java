package pl.gorczynski.admin.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.gorczynski.admin.model.shop.product.Category;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryDTO {

    private Integer id;
    private String title;
    private String metaTitle;
    private String content;
    private CategoryDTO categoryDTO;
}
