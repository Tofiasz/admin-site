package pl.gorczynski.admin.mapper.product;

import org.springframework.stereotype.Component;
import pl.gorczynski.admin.dto.product.ProductReviewDTO;
import pl.gorczynski.admin.model.shop.product.ProductReview;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductReviewMapper {

    public ProductReviewDTO toProductReviewDTO(final ProductReview productReview) {
        return new ProductReviewDTO(productReview.getId(),
                productReview.getProduct(),
                productReview.getReviewTitle(),
                productReview.getReviewRating(),
                productReview.getPublishedDate(),
                productReview.getReview());
    }

    public List<ProductReviewDTO> toProductReviewDTOList(final List<ProductReview> productReviewList) {
        return productReviewList
                .stream()
                .map(this::toProductReviewDTO)
                .collect(Collectors.toList());
    }

    public ProductReview toProductReview(final ProductReviewDTO productReviewDTO) {
        if (productReviewDTO == null) {
            return new ProductReview();
        }

        return new ProductReview(productReviewDTO.getProduct(),
                productReviewDTO.getReviewTitle(),
                productReviewDTO.getReviewRating(),
                productReviewDTO.getPublishedDate(),
                productReviewDTO.getReview());
    }

    public List<ProductReview> toProductReviewList(final List<ProductReviewDTO> productReviewDTOList) {
        if (productReviewDTOList == null) {
            return new ArrayList<>();
        }

        return productReviewDTOList
                .stream()
                .map(this::toProductReview)
                .collect(Collectors.toList());
    }
}
