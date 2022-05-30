package pl.gorczynski.admin.mapper.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gorczynski.admin.dto.product.ProductCategoryDTO;
import pl.gorczynski.admin.model.shop.product.ProductCategory;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductCategoryMapper {

    private final CategoryMapper categoryMapper;

    @Autowired
    public ProductCategoryMapper(final CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    public ProductCategoryDTO toProductCategoryDTO(final ProductCategory productCategory) {
//        if (productCategory == null) {
//            return new ProductCategoryDTO();
//        }

        return new ProductCategoryDTO(productCategory.getId(),
                productCategory.getTitle(),
                productCategory.getMetaTitle(),
                productCategory.getContent(),
                categoryMapper.toCategoryDTO(productCategory.getCategory()));
    }

    public List<ProductCategoryDTO> toProductCategoryDTOList(final List<ProductCategory> productCategoryList) {
        return productCategoryList
                .stream()
                .map(this::toProductCategoryDTO)
                .collect(Collectors.toList());
    }

    public ProductCategory toProductCategory(final ProductCategoryDTO productCategoryDTO) {
        return new ProductCategory(productCategoryDTO.getId(),
                productCategoryDTO.getTitle(),
                productCategoryDTO.getMetaTitle(),
                productCategoryDTO.getContent(),
                categoryMapper.toCategory(productCategoryDTO.getCategoryDTO()));
    }

    public ProductCategory toProductCategoryForCorrelatedEntities(final ProductCategoryDTO productCategoryDTO) {
        return new ProductCategory(productCategoryDTO.getId());
    }

    public List<ProductCategory> toProductCategoryList(final List<ProductCategoryDTO> productCategoryDTOList) {
        return productCategoryDTOList
                .stream()
                .map(this::toProductCategory)
                .collect(Collectors.toList());
    }
}
