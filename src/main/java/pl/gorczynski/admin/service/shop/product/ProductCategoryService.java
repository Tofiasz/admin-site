package pl.gorczynski.admin.service.shop.product;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.gorczynski.admin.dto.product.ProductCategoryDTO;
import pl.gorczynski.admin.mapper.product.CategoryMapper;
import pl.gorczynski.admin.mapper.product.ProductCategoryMapper;
import pl.gorczynski.admin.model.shop.product.ProductCategory;
import pl.gorczynski.admin.repository.shop.product.ProductCategoryRepository;

import java.util.List;

@Service
@Getter
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;
    private final ProductCategoryMapper productCategoryMapper;
    private final CategoryMapper categoryMapper;
    private Integer pageNumberSearchFor;

    @Autowired
    public ProductCategoryService(final ProductCategoryRepository productCategoryRepository,
                                  final ProductCategoryMapper productCategoryMapper,
                                  final CategoryMapper categoryMapper) {
        this.productCategoryRepository = productCategoryRepository;
        this.productCategoryMapper = productCategoryMapper;
        this.categoryMapper = categoryMapper;
    }

    public void addNewProductCategory(final ProductCategoryDTO productCategoryDTO) {
        ProductCategory productCategory = productCategoryMapper.toProductCategory(productCategoryDTO);
        productCategoryRepository.save(productCategory);
    }

    public List<ProductCategoryDTO> getAllProductCategoryList() {
        List<ProductCategory> productCategoryList = productCategoryRepository.findAll();

        return productCategoryMapper.toProductCategoryDTOList(productCategoryList);
    }

    public List<ProductCategoryDTO> getPageWithProductCategories(final Integer pageNumber) {
        List<ProductCategory> productCategoryList =
                productCategoryRepository.findAll(PageRequest.of(pageNumber, 10)).toList();

        return productCategoryMapper.toProductCategoryDTOList(productCategoryList);
    }

    public List<ProductCategoryDTO> getPageWithProductCategoriesWithSearchFor(final String searchFor,
                                                                              final Integer pageNumber) {
        List<ProductCategory> productCategoryList = productCategoryRepository.findAll(searchFor);
        PagedListHolder<ProductCategory> productCategoryPagedListHolder = new PagedListHolder<>(productCategoryList);
        productCategoryPagedListHolder.setPageSize(10);
        productCategoryPagedListHolder.setPage(pageNumber);
        pageNumberSearchFor = productCategoryPagedListHolder.getPageCount();

        return productCategoryMapper.toProductCategoryDTOList(productCategoryPagedListHolder.getPageList());
    }

    public Integer getPagesNumber() {
        return (int) Math.ceil(productCategoryRepository.count() / 10.0);
    }

    public void updateProductCategory(final ProductCategoryDTO productCategoryDTO) {
        Integer productCategoryId = productCategoryDTO.getId();
        ProductCategory productCategory = productCategoryRepository.findById(productCategoryId)
                .orElseThrow();
        productCategory.setTitle(productCategoryDTO.getTitle());
        productCategory.setMetaTitle(productCategoryDTO.getMetaTitle());
        productCategory.setContent(productCategoryDTO.getContent());
        productCategory.setCategory(categoryMapper.toCategory(productCategoryDTO.getCategoryDTO()));
        productCategoryRepository.save(productCategory);
    }

    private ProductCategory getProductCategoryById(final Integer productCategoryId) {

        return productCategoryRepository.findById(productCategoryId).orElseThrow();
    }

    public ProductCategoryDTO getProductCategoryDTOById(final Integer productCategoryDTOId) {
        ProductCategory productCategory = getProductCategoryById(productCategoryDTOId);

        return productCategoryMapper.toProductCategoryDTO(productCategory);
    }

    public void deleteProductCategoryById(final Integer productCategoryId) {
        productCategoryRepository.deleteById(productCategoryId);
    }
}
