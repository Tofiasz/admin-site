package pl.gorczynski.admin.controller.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gorczynski.admin.dto.product.ProductCategoryDTO;
import pl.gorczynski.admin.service.shop.product.CategoryService;
import pl.gorczynski.admin.service.shop.product.ProductCategoryService;

@Controller
@RequestMapping("/categories")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;
    private final CategoryService categoryService;

    @Autowired
    public ProductCategoryController(final ProductCategoryService productCategoryService,
                                     final CategoryService categoryService) {
        this.productCategoryService = productCategoryService;
        this.categoryService = categoryService;
    }

    @ModelAttribute
    public void addCondition(final Model model) {
        model.addAttribute("condition", "categories");
    }

    @GetMapping("/all-product-categories")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String getAllProductCategories(final Model model,
                                          @RequestParam(value = "page-number", required = false, defaultValue = "0")
                                          final Integer pageNumber) {
        model.addAttribute("pagesNumber", productCategoryService.getPagesNumber());
        model.addAttribute("productCategoriesList", productCategoryService.getPageWithProductCategories(pageNumber));
        model.addAttribute("searching", false);

        return "categories/allProductCategories";
    }

    @GetMapping("/search-for-product-category")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String searchForProductCategory(@RequestParam(value = "search-for") final String searchFor,
                                           @RequestParam(value = "page-number", required = false, defaultValue = "0")
                                           final Integer pageNumber,
                                           final Model model) {
        model.addAttribute("productCategoriesList",
                productCategoryService.getPageWithProductCategoriesWithSearchFor(searchFor, pageNumber));
        model.addAttribute("pagesNumber", productCategoryService.getPageNumberSearchFor());
        model.addAttribute("searching", true);
        model.addAttribute("searchFor", searchFor);

        return "categories/allProductCategories";
    }

    @GetMapping("/add-new-product-category")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String addNewProductCategory(final Model model) {
        model.addAttribute("productCategory", new ProductCategoryDTO());
        model.addAttribute("categoriesList", categoryService.getAllCategoryList());

        return "categories/newProductCategory";
    }

    @PostMapping("/add-new-product-category")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String addNewProductCategory(@ModelAttribute final ProductCategoryDTO productCategoryDTO) {
        productCategoryService.addNewProductCategory(productCategoryDTO);

        return "redirect:/categories/all-product-categories";
    }

    @GetMapping("/update-product-category-by-id")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String updateProductCategory(@RequestParam(value = "id") final Integer productCategoryDTOId,
                                        final Model model) {
        model.addAttribute("productCategoryDTO", productCategoryService.getProductCategoryDTOById(productCategoryDTOId));
        model.addAttribute("newProductCategoryDTO", new ProductCategoryDTO());
        model.addAttribute("categoriesList", categoryService.getAllCategoryList());

        return "categories/updateProductCategory";
    }

    @PostMapping("/update-product-category")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String updateProductCategory(@ModelAttribute final ProductCategoryDTO productCategoryDTO) {
        productCategoryService.updateProductCategory(productCategoryDTO);

        return "redirect:/categories/all-product-categories";
    }

    @GetMapping("/delete-product-category-by-id")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteProductCategoryById(@RequestParam(value = "id") final Integer productCategoryId) {
        productCategoryService.deleteProductCategoryById(productCategoryId);

        return "redirect:/categories/all-product-categories";
    }
}
