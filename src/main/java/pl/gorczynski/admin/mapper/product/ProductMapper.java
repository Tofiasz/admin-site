package pl.gorczynski.admin.mapper.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gorczynski.admin.dto.product.ProductDTO;
import pl.gorczynski.admin.model.shop.product.Product;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    private final ProductCategoryMapper productCategoryMapper;
    private final ProductReviewMapper productReviewMapper;
    private final ProductImageMapper productImageMapper;
    private final ProductTypeMapper productTypeMapper;

    @Autowired
    public ProductMapper(final ProductCategoryMapper productCategoryMapper,
                         final ProductReviewMapper productReviewMapper,
                         final ProductImageMapper productImageMapper,
                         final ProductTypeMapper productTypeMapper) {
        this.productCategoryMapper = productCategoryMapper;
        this.productReviewMapper = productReviewMapper;
        this.productImageMapper = productImageMapper;
        this.productTypeMapper = productTypeMapper;
    }

    public ProductDTO toProductDTO(final Product product) {
        return new ProductDTO(product.getId(),
                product.getTitle(),
                product.getMetaTitle(),
                product.getStockKeepingUnit(),
                product.getCodeEAN(),
                product.getPrice(),
                product.getDiscount(),
                product.getTax(),
                product.getQuantity(),
                product.getProductAvailable(),
                product.getCreatedAt(),
                product.getUpdatedAt(),
                product.getPublishedAt(),
                product.getSaleStartAt(),
                product.getSaleEndsAt(),
                product.getContent(),
                productCategoryMapper.toProductCategoryDTO(product.getProductCategory()),
                productReviewMapper.toProductReviewDTOList(product.getProductReviewList()),
                productImageMapper.toProductImageDTOList(product.getProductImageList()),
                productTypeMapper.toProductTypeDTO(product.getProductType()));
    }

    public List<ProductDTO> toProductDTOList(final List<Product> productList) {
        return productList
                .stream()
                .map(this::toProductDTO)
                .collect(Collectors.toList());
    }

    public Product toProduct(final ProductDTO productDTO) {
        return new Product(productDTO.getId(),
                productDTO.getTitle(),
                productDTO.getMetaTitle(),
                productDTO.getStockKeepingUnit(),
                productDTO.getCodeEAN(),
                productDTO.getPrice(),
                productDTO.getDiscount(),
                productDTO.getTax(),
                productDTO.getQuantity(),
                productDTO.getProductAvailable(),
                productDTO.getCreatedAt(),
                productDTO.getUpdatedAt(),
                productDTO.getPublishedAt(),
                productDTO.getSaleStartAt(),
                productDTO.getSaleEndsAt(),
                productDTO.getContent(),
                productCategoryMapper.toProductCategoryForCorrelatedEntities(productDTO.getProductCategoryDTO()),
                productReviewMapper.toProductReviewList(productDTO.getProductReviewDTOList()),
                productImageMapper.toProductImageList(productDTO.getProductImageDTOList()),
                productTypeMapper.toProductTypeForCorrelatedEntities(productDTO.getProductTypeDTO()));
    }

    public List<Product> toProductList(final List<ProductDTO> productDTOList) {
        return productDTOList.stream()
                .map(this::toProduct)
                .collect(Collectors.toList());
    }
}
