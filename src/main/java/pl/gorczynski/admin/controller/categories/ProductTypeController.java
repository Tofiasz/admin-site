package pl.gorczynski.admin.controller.categories;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gorczynski.admin.dto.product.ProductTypeDTO;
import pl.gorczynski.admin.service.shop.product.ProductCategoryService;
import pl.gorczynski.admin.service.shop.product.ProductTypeService;

@Controller
@RequestMapping("/categories")
public class ProductTypeController {

    private final ProductTypeService productTypeService;
    private final ProductCategoryService productCategoryService;

    public ProductTypeController(final ProductTypeService productTypeService,
                                 final ProductCategoryService productCategoryService) {
        this.productTypeService = productTypeService;
        this.productCategoryService = productCategoryService;
    }

    @ModelAttribute
    public void addCondition(final Model model) {
        model.addAttribute("condition", "categories");
    }

    @GetMapping("/all-product-types")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String getAllProductTypes(final Model model,
                                     @RequestParam(value = "page-number", required = false, defaultValue = "0")
                                     final Integer pageNumber) {
        model.addAttribute("productTypesList", productTypeService.getPageWithProductTypes(pageNumber));
        model.addAttribute("pagesNumber", productTypeService.getPagesNumber());
        model.addAttribute("searching", false);

        return "categories/allProductTypes";
    }

    @GetMapping("/search-for-product-type")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String searchForProductType(@RequestParam(value = "search-for") final String searchFor,
                                       @RequestParam(value = "page-number", required = false, defaultValue = "0")
                                       final Integer pageNumber,
                                       final Model model) {
        model.addAttribute("productTypesList",
                productTypeService.getPageWithProductTypesWithSearchFor(searchFor, pageNumber));
        model.addAttribute("pagesNumber", productTypeService.getPageNumberSearchFor());
        model.addAttribute("searching", true);
        model.addAttribute("searchFor", searchFor);

        return "categories/allProductTypes";
    }

    @GetMapping("/add-new-product-type")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String addNewProductType(final Model model) {
        model.addAttribute("productType", new ProductTypeDTO());
        model.addAttribute("productCategoriesList", productCategoryService.getAllProductCategoryList());

        return "categories/newProductType";
    }

    @PostMapping("/add-new-product-type")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String addNewProductType(@ModelAttribute final ProductTypeDTO productTypeDTO) {
        productTypeService.addNewProductType(productTypeDTO);

        return "redirect:/categories/all-product-types";
    }

    @GetMapping("/delete-product-type-by-id")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteProductTypeById(@RequestParam(name = "id") final Integer productTypeId) {
        productTypeService.deleteProductTypeById(productTypeId);

        return "redirect:/categories/all-product-types";
    }

    @GetMapping("/update-product-type-by-id")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String updateProductType(@RequestParam(value = "id") final Integer productTypeId,
                                    final Model model) {
        model.addAttribute("productTypeDTO", productTypeService.getProductTypeDTObyId(productTypeId));
        model.addAttribute("newProductTypeDTO", new ProductTypeDTO());
        model.addAttribute("productCategoriesList", productCategoryService.getAllProductCategoryList());

        return "categories/updateProductType";
    }

    @PostMapping("/update-product-type")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String updateProductType(@ModelAttribute final ProductTypeDTO productTypeDTO) {
        productTypeService.updateProductType(productTypeDTO);

        return "redirect:/categories/all-product-types";
    }
}
