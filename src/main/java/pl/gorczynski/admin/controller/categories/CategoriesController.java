package pl.gorczynski.admin.controller.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gorczynski.admin.dto.product.CategoryDTO;
import pl.gorczynski.admin.dto.product.ProductCategoryDTO;
import pl.gorczynski.admin.dto.product.ProductTypeDTO;
import pl.gorczynski.admin.service.shop.product.CategoryService;
import pl.gorczynski.admin.service.shop.product.ProductCategoryService;
import pl.gorczynski.admin.service.shop.product.ProductTypeService;

@Controller
@RequestMapping("/categories")
public class CategoriesController {

    @ModelAttribute
    public void addCondition(final Model model) {
        model.addAttribute("condition", "categories");
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String getCategories() {

        return "categories/categories";
    }
}