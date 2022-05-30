package pl.gorczynski.admin.mapper.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gorczynski.admin.dto.product.ProductTypeDTO;
import pl.gorczynski.admin.model.shop.product.ProductType;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductTypeMapper {

    private final ProductCategoryMapper productCategoryMapper;

    @Autowired
    public ProductTypeMapper(final ProductCategoryMapper productCategoryMapper) {
        this.productCategoryMapper = productCategoryMapper;
    }

    public ProductTypeDTO toProductTypeDTO(final ProductType productType) {
        return new ProductTypeDTO(productType.getId(),
                productType.getTitle(),
                productType.getMetaTitle(),
                productType.getContent(),
                productCategoryMapper.toProductCategoryDTO(productType.getProductCategory()));
    }

    public List<ProductTypeDTO> toProductTypeDTOList(final List<ProductType> productTypeList) {
        return productTypeList.stream()
                .map(this::toProductTypeDTO)
                .collect(Collectors.toList());
    }

    public ProductType toProductType(final ProductTypeDTO productTypeDTO) {
        return new ProductType(productTypeDTO.getId(),
                productTypeDTO.getTitle(),
                productTypeDTO.getMetaTitle(),
                productTypeDTO.getContent(),
                productCategoryMapper.toProductCategory(productTypeDTO.getProductCategoryDTO()));
    }

    public ProductType toProductTypeForCorrelatedEntities(final ProductTypeDTO productTypeDTO) {
        return new ProductType(productTypeDTO.getId());
    }

    public List<ProductType> toProductTypeList(final List<ProductTypeDTO> productTypeDTOList) {
        return productTypeDTOList.stream()
                .map(this::toProductType)
                .collect(Collectors.toList());
    }
}
