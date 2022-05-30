package pl.gorczynski.admin.controller.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gorczynski.admin.dao.OrderDAOImpl;
import pl.gorczynski.admin.dao.PaymentDAOImpl;
import pl.gorczynski.admin.dao.ShipperDAOImpl;
import pl.gorczynski.admin.dto.product.CategoryDTO;
import pl.gorczynski.admin.service.shop.product.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(final CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ModelAttribute
    public void addCondition(final Model model) {
        model.addAttribute("condition", "categories");
    }

    @GetMapping("/all-categories")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String getAllCategories(final Model model,
                                   @RequestParam(value = "page-number", required = false, defaultValue = "0")
                                   final Integer pageNumber) {
        model.addAttribute("pagesNumber", categoryService.getCategoryPagesNumber());
        model.addAttribute("categoriesList", categoryService.getPageWithCategories(pageNumber));
        model.addAttribute("searching", false);

        return "categories/allCategories";
    }

    @GetMapping("/search-for-category")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String searchForCategory(@RequestParam(value = "search-for") final String searchFor,
                                    @RequestParam(value = "page-number", required = false, defaultValue = "0")
                                    final Integer pageNumber,
                                    final Model model) {
        model.addAttribute("categoriesList",
                categoryService.getPageWithCategoriesWithSearchFor(searchFor, pageNumber));
        model.addAttribute("pagesNumber", categoryService.getPageNumberSearchFor());
        model.addAttribute("searching", true);
        model.addAttribute("searchFor", searchFor);

        return "categories/allCategories";
    }

    @GetMapping("/add-new-category")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String addNewCategory(final Model model) {
        model.addAttribute("category", new CategoryDTO());

        return "categories/newCategory";
    }

    @PostMapping("/add-new-category")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String addNewCategory(@ModelAttribute final CategoryDTO categoryDTO) {
        categoryService.addNewCategory(categoryDTO);

        return "redirect:/categories/all-categories";
    }

    @GetMapping("/update-category-by-id")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String updateCategory(@RequestParam(value = "id") final Integer id,
                                 final Model model) {
        model.addAttribute("categoryDTO", categoryService.getCategoryDTOById(id));
        model.addAttribute("newCategoryDTO", new CategoryDTO());

        return "categories/updateCategory";
    }

    @PostMapping("/update-category")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String updateCategory(@ModelAttribute final CategoryDTO categoryDTO) {
        categoryService.updateCategory(categoryDTO);

        return "redirect:/categories/all-categories";
    }

    @GetMapping("/delete-category-by-id")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteCategory(@RequestParam(value = "id") final Integer id) {
        categoryService.deleteCategoryById(id);

        return "redirect:/categories/all-categories";
    }
}
