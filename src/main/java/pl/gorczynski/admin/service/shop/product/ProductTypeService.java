package pl.gorczynski.admin.service.shop.product;

import lombok.Getter;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.gorczynski.admin.dto.product.ProductCategoryDTO;
import pl.gorczynski.admin.dto.product.ProductTypeDTO;
import pl.gorczynski.admin.mapper.product.ProductCategoryMapper;
import pl.gorczynski.admin.mapper.product.ProductTypeMapper;
import pl.gorczynski.admin.model.shop.product.ProductType;
import pl.gorczynski.admin.repository.shop.product.ProductTypeRepository;

import java.util.List;

@Service
public class ProductTypeService {

    private final ProductTypeRepository productTypeRepository;
    private final ProductTypeMapper productTypeMapper;
    private final ProductCategoryService productCategoryService;
    private final ProductCategoryMapper productCategoryMapper;
    private Integer pageNumberSearchFor;

    public ProductTypeService(final ProductTypeRepository productTypeRepository,
                              final ProductTypeMapper productTypeMapper,
                              final ProductCategoryService productCategoryService,
                              final ProductCategoryMapper productCategoryMapper) {
        this.productTypeRepository = productTypeRepository;
        this.productTypeMapper = productTypeMapper;
        this.productCategoryService = productCategoryService;
        this.productCategoryMapper = productCategoryMapper;
    }

    public List<ProductTypeDTO> getAllProductTypesList() {
        List<ProductType> productTypeList = productTypeRepository.findAll();

        return productTypeMapper.toProductTypeDTOList(productTypeList);
    }

    public List<ProductTypeDTO> getPageWithProductTypesWithSearchFor(final String searchFor,
                                                               final Integer pageNumber) {
        List<ProductType> productTypeList = productTypeRepository.findAll(searchFor);
        PagedListHolder<ProductType> productTypePagedListHolder = new PagedListHolder<>(productTypeList);
        productTypePagedListHolder.setPageSize(10);
        productTypePagedListHolder.setPage(pageNumber);
        pageNumberSearchFor = productTypePagedListHolder.getPageCount();

        return productTypeMapper.toProductTypeDTOList(productTypePagedListHolder.getPageList());
    }

    public List<ProductTypeDTO> getPageWithProductTypes(final Integer pageNumber) {
        List<ProductType> productTypeList = productTypeRepository.findAll(PageRequest.of(pageNumber, 10)).toList();

        return productTypeMapper.toProductTypeDTOList(productTypeList);
    }

    public Integer getPagesNumber() {
        return (Integer) (int) Math.ceil(productTypeRepository.count() / 10.0);
    }

    private void save(final ProductType productType) {
        productTypeRepository.save(productType);
    }

    public void addNewProductType(final ProductTypeDTO productTypeDTO) {
        ProductCategoryDTO productCategoryDTO =
                productCategoryService.getProductCategoryDTOById(productTypeDTO.getProductCategoryDTO().getId());
        productTypeDTO.setProductCategoryDTO(productCategoryDTO);
        ProductType productType = productTypeMapper.toProductType(productTypeDTO);
        save(productType);
    }

    public ProductTypeDTO getProductTypeDTObyId(final Integer productTypeId) {
        ProductType productType = getProductTypeById(productTypeId);

        return productTypeMapper.toProductTypeDTO(productType);
    }

    public ProductType getProductTypeById(final Integer productTypeId) {
        return productTypeRepository.findById(productTypeId).orElseThrow();
    }

    public void deleteProductTypeById(final Integer productTypeId) {
        productTypeRepository.deleteById(productTypeId);
    }

    public void updateProductType(final ProductTypeDTO productTypeDTO) {
        ProductType productType = productTypeRepository.findById(productTypeDTO.getId()).orElseThrow();
        ProductCategoryDTO productCategoryDTO =
                productCategoryService.getProductCategoryDTOById(productTypeDTO.getProductCategoryDTO().getId());
        productType.setTitle(productTypeDTO.getTitle());
        productType.setMetaTitle(productType.getMetaTitle());
        productType.setContent(productType.getContent());
        productType.setProductCategory(productCategoryMapper.toProductCategory(productCategoryDTO));
        save(productType);
    }

    public Integer getPageNumberSearchFor() {
            return pageNumberSearchFor;
    }
}
