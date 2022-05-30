package pl.gorczynski.admin.service.shop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.gorczynski.admin.dto.product.ProductDTO;
import pl.gorczynski.admin.dto.product.ProductImageDTO;
import pl.gorczynski.admin.mapper.product.*;
import pl.gorczynski.admin.model.shop.product.Product;
import pl.gorczynski.admin.model.shop.product.ProductImage;
import pl.gorczynski.admin.model.shop.product.ProductType;
import pl.gorczynski.admin.repository.shop.product.ProductRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductCategoryMapper productCategoryMapper;
    private final ProductTypeMapper productTypeMapper;
    private final ProductReviewMapper productReviewMapper;
    private final ProductImageMapper productImageMapper;
    private final ProductCategoryService productCategoryService;
    private final ProductImageService productImageService;
    private final ProductTypeService productTypeService;

    @Autowired
    public ProductService(final ProductRepository productRepository,
                          final ProductMapper productMapper,
                          final ProductCategoryMapper productCategoryMapper,
                          final ProductTypeMapper productTypeMapper,
                          final ProductReviewMapper productReviewMapper,
                          final ProductImageMapper productImageMapper,
                          final ProductCategoryService productCategoryService,
                          final ProductImageService productImageService,
                          final ProductTypeService productTypeService) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.productCategoryMapper = productCategoryMapper;
        this.productTypeMapper = productTypeMapper;
        this.productReviewMapper = productReviewMapper;
        this.productImageMapper = productImageMapper;
        this.productCategoryService = productCategoryService;
        this.productImageService = productImageService;
        this.productTypeService = productTypeService;
    }

    private void save(final Product product) {
        productRepository.save(product);
    }

    public Integer countAllProducts() {
        return Math.toIntExact(productRepository.count());
    }

    public List<ProductDTO> getPageWithProducts(final Integer pageNumber) {
        List<Product> productList = productRepository.findAll(PageRequest.of(pageNumber, 10)).toList();

        return productMapper.toProductDTOList(productList);
    }

    public Integer getPagesNumber() {
        return (Integer) (int) Math.ceil(productRepository.count() / 10.0);
    }
    public void addNewProduct(final ProductDTO productDTO,
                              final List<MultipartFile> multipartFileList) {
        List<ProductImageDTO> productImageDTOList = getProductImageDTOListIfImageAdded(multipartFileList);

        productDTO.setProductImageDTOList(productImageDTOList);
        productDTO.setCreatedAt(new Date());
        productDTO.setQuantity(0);
        Product product = productMapper.toProduct(productDTO);
        save(product);
    }

    private List<ProductImageDTO> getProductImageDTOListIfImageAdded(final List<MultipartFile> multipartFileList) {
        if (!multipartFileList.get(0).getOriginalFilename().equals("")) {
            return productImageService.getProductImagesListFromMultipartFileList(multipartFileList);
        }

        return new ArrayList<>();
    }

    public List<ProductDTO> getAllProductDTOList() {
        List<Product> productList = productRepository.findAll();

        return productMapper.toProductDTOList(productList);
    }

    public ProductDTO getProductDTOById(final Integer productId) {
        Product product = getProductById(productId);

        return productMapper.toProductDTO(product);
    }

    public Product getProductById(final Integer productId) {
        return productRepository.findById(productId).orElseThrow();
    }
    public void updateProduct(final ProductDTO productDTO) {
        Product product = productRepository.findById(productDTO.getId()).orElseThrow();
        ProductType productType = productTypeService.getProductTypeById(product.getProductType().getId());
        product.setTitle(productDTO.getTitle());
        product.setMetaTitle(productDTO.getMetaTitle());
        product.setStockKeepingUnit(productDTO.getStockKeepingUnit());
        product.setCodeEAN(productDTO.getCodeEAN());
        product.setPrice(productDTO.getPrice());
        product.setDiscount(productDTO.getDiscount());
        product.setTax(productDTO.getTax());
        product.setQuantity(productDTO.getQuantity());
        product.setProductAvailable(productDTO.getProductAvailable());
        product.setCreatedAt(productDTO.getCreatedAt());
        product.setUpdatedAt(productDTO.getUpdatedAt());
        product.setPublishedAt(productDTO.getPublishedAt());
        product.setSaleStartAt(productDTO.getSaleStartAt());
        product.setSaleEndsAt(productDTO.getSaleEndsAt());
        product.setContent(productDTO.getContent());
        product.setProductCategory(productCategoryMapper.toProductCategory(productDTO.getProductCategoryDTO()));
        product.setProductReviewList(productReviewMapper.toProductReviewList(productDTO.getProductReviewDTOList()));
        product.setProductType(productType);
        save(product);
    }

    public void deleteProductById(final Integer productId) {
        productRepository.deleteById(productId);
    }

    public void deleteImageFromProductById(final Integer imageId,
                                           final Integer productId) {
        Product product = getProductById(productId);

        List<ProductImage> productImageList = product.getProductImageList();
        List<ProductImage> productImageListWithRemovedImage = productImageList.stream()
                .filter(productImage -> !productImage.getId().equals(imageId))
                .collect(Collectors.toList());

        product.setProductImageList(productImageListWithRemovedImage);
        save(product);
    }
}
