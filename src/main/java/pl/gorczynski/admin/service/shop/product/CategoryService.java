package pl.gorczynski.admin.service.shop.product;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.gorczynski.admin.dto.product.CategoryDTO;
import pl.gorczynski.admin.mapper.product.CategoryMapper;
import pl.gorczynski.admin.model.shop.product.Category;
import pl.gorczynski.admin.model.shop.user.Customer;
import pl.gorczynski.admin.repository.shop.product.CategoryRepository;

import java.util.List;

@Service
@Getter
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private Integer pageNumberSearchFor;

    @Autowired
    public CategoryService(final CategoryRepository categoryRepository,
                           final CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public Category getCategoryById(final Integer categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow();
    }

    public CategoryDTO getCategoryDTOById(final Integer categoryId) {
        Category category = getCategoryById(categoryId);

        return categoryMapper.toCategoryDTO(category);
    }

    public List<CategoryDTO> getAllCategoryList() {
        List<Category> categoryList = categoryRepository.findAll();

        return categoryMapper.toCategoryDTOList(categoryList);
    }

    public List<CategoryDTO> getPageWithCategories(final Integer pageNumber) {
        List<Category> categoryList = categoryRepository.findAll(PageRequest.of(pageNumber, 10)).toList();

        return categoryMapper.toCategoryDTOList(categoryList);
    }

    public Integer getCategoryPagesNumber() {
        return (Integer) (int) Math.ceil(categoryRepository.count() / 10.0);
    }
    public void addNewCategory(final CategoryDTO categoryDTO) {
        Category category = categoryMapper.toCategory(categoryDTO);
        categoryRepository.save(category);
    }

    public void updateCategory(final CategoryDTO categoryDTO) {
        Integer categoryId = categoryDTO.getId();
        Category category = getCategoryById(categoryId);
        category.setContent(categoryDTO.getContent());
        category.setMetaTitle(categoryDTO.getMetaTitle());
        category.setTitle(categoryDTO.getTitle());
        categoryRepository.save(category);
    }

    public void deleteCategoryById(final Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    public List<CategoryDTO> getPageWithCategoriesWithSearchFor(final String searchFor,
                                                                final Integer pageNumber) {
        List<Category> categoryList = categoryRepository.findAll(searchFor);
        PagedListHolder<Category> customerPagedListHolder = new PagedListHolder<>(categoryList);
        customerPagedListHolder.setPageSize(10);
        customerPagedListHolder.setPage(pageNumber);
        pageNumberSearchFor = customerPagedListHolder.getPageCount();

        return categoryMapper.toCategoryDTOList(customerPagedListHolder.getPageList());
    }
}
