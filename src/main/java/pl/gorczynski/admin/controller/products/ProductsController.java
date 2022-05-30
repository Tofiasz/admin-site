package pl.gorczynski.admin.controller.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.gorczynski.admin.dto.product.ProductDTO;
import pl.gorczynski.admin.service.shop.product.ProductCategoryService;
import pl.gorczynski.admin.service.shop.product.ProductService;
import pl.gorczynski.admin.service.shop.product.ProductTypeService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private final ProductService productService;
    private final ProductCategoryService productCategoryService;
    private final ProductTypeService productTypeService;

    @Autowired
    public ProductsController(final ProductService productService,
                              final ProductCategoryService productCategoryService,
                              final ProductTypeService productTypeService) {
        this.productService = productService;
        this.productCategoryService = productCategoryService;
        this.productTypeService = productTypeService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String getProducts(final Model model) {
        model.addAttribute("condition", "products");

        return "products/products";
    }

    @GetMapping("/all-products")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String getAllProducts(final Model model,
                                 @RequestParam(value = "page-number", required = false, defaultValue = "0")
                                 final Integer pageNumber) {
        model.addAttribute("productsList", productService.getPageWithProducts(pageNumber));
        model.addAttribute("pagesNumber", productService.getPagesNumber());

        return "products/allProducts";
    }

    @GetMapping("/add-new-product")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String addNewProduct(final Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("productCategoriesList", productCategoryService.getAllProductCategoryList());
        model.addAttribute("productTypesList", productTypeService.getAllProductTypesList());
        List<MultipartFile> multipartFileList = new ArrayList<>();
        model.addAttribute("multipartFileList", multipartFileList);

        return "products/newProduct";
    }

    @PostMapping("/add-new-product")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String addNewProduct(@ModelAttribute final ProductDTO productDTO,
                                @ModelAttribute(value = "multipartFileList") final List<MultipartFile> multipartFileList) {

        productService.addNewProduct(productDTO, multipartFileList);

        return "redirect:/products/all-products";
    }

    @GetMapping("/delete-product-by-id")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteProductById(@RequestParam(value = "id") final Integer productId) {
        productService.deleteProductById(productId);

        return "redirect:/products/all-products";
    }

    @GetMapping("/get-product-by-id")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String updateProductById(@RequestParam(value = "id") final Integer productId,
                                    final Model model) {
        model.addAttribute("productDTO", productService.getProductDTOById(productId));
        model.addAttribute("newProductDTO", new ProductDTO());
        model.addAttribute("productCategoriesList", productCategoryService.getAllProductCategoryList());
        model.addAttribute("productTypesList", productTypeService.getAllProductTypesList());

        return "products/product";
    }

    @PostMapping("/update-product")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String updateProductById(@ModelAttribute final ProductDTO productDTO) {
        productService.updateProduct(productDTO);

        return "redirect:/products/get-product-by-id?id=" + productDTO.getId().toString();
    }

    @GetMapping("/delete-product-image-by-id")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteImageFromProductById(@RequestParam(value = "image-id") final Integer imageId,
                                             @RequestParam(value = "product-id") final Integer productId) {
        productService.deleteImageFromProductById(imageId, productId);

        return "redirect:/products/get-product-by-id?id=" + productId;
    }
//    @GetMapping(value = "/upload")
//    public String uploadImage() {
//
//        return "image/imageUpload";
//    }

//    @PostMapping(value = "/upload-image")
//    public String uploadImage(@RequestParam(name = "image") final MultipartFile multipartFile) throws IOException {
//        productImageService.uploadImage(multipartFile);
//
//        return "redirect:/products/image1";
//    }
//
//    @GetMapping(value = "/image1")
//    public String getFirstImage(Model model) {
//        String imageBase64 = Base64.getEncoder().encodeToString(productImageService.getProductImageById(1).getImage());
//        model.addAttribute("image", imageBase64);
//        return "image/image";
//    }
}
