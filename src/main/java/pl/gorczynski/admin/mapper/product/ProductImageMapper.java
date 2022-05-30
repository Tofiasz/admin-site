package pl.gorczynski.admin.mapper.product;

import org.springframework.stereotype.Component;
import pl.gorczynski.admin.dto.product.ProductImageDTO;
import pl.gorczynski.admin.model.shop.product.ProductImage;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductImageMapper {

    public ProductImageDTO toProductImageDTO(final ProductImage productImage) {
        return new ProductImageDTO(productImage.getId(),
                productImage.getName(),
                productImage.getUploadedAt(),
                productImage.getImage());
    }

    public List<ProductImageDTO> toProductImageDTOList(final List<ProductImage> productImageList) {
        return productImageList
                .stream()
                .map(this::toProductImageDTO)
                .collect(Collectors.toList());
    }

    public ProductImage toProductImage(final ProductImageDTO productImageDTO) {
        return new ProductImage(productImageDTO.getId(),
                productImageDTO.getName(),
                productImageDTO.getImage());
    }

    public List<ProductImage> toProductImageList(final List<ProductImageDTO> productImageDTOList) {
        return productImageDTOList
                .stream()
                .map(this::toProductImage)
                .collect(Collectors.toList());
    }
}
