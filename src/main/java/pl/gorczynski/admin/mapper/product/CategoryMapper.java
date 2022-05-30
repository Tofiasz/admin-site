package pl.gorczynski.admin.mapper.product;

import org.springframework.stereotype.Component;
import pl.gorczynski.admin.dto.product.CategoryDTO;
import pl.gorczynski.admin.model.shop.product.Category;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    public CategoryDTO toCategoryDTO(final Category category) {
        return new CategoryDTO(category.getId(),
                category.getTitle(),
                category.getMetaTitle(),
                category.getContent());
    }

    public List<CategoryDTO> toCategoryDTOList(final List<Category> categoryList) {
        return categoryList
                .stream()
                .map(this::toCategoryDTO)
                .collect(Collectors.toList());
    }

    public Category toCategory(final CategoryDTO categoryDTO) {
        if (categoryDTO == null) {
            return new Category();
        }

        return new Category(categoryDTO.getId(),
                categoryDTO.getTitle(),
                categoryDTO.getMetaTitle(),
                categoryDTO.getContent());
    }

    public List<Category> toCategoryList(final List<CategoryDTO> categoryDTOList) {
        return categoryDTOList
                .stream()
                .map(this::toCategory)
                .collect(Collectors.toList());
    }
}
