package pl.gorczynski.admin.controller.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gorczynski.admin.dto.user.CustomerDTO;
import pl.gorczynski.admin.model.shop.user.Customer;
import pl.gorczynski.admin.service.user.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomersController {

    private final CustomerService customerService;

    @Autowired
    public CustomersController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String getCustomers(final Model model) {
        model.addAttribute("condition", "customers");

        return "customers/customers";
    }

    @GetMapping("/all-customers")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String getCustomersList(final Model model,
                                   @RequestParam(value = "page-number", required = false, defaultValue = "0")
                                   final Integer pageNumber) {
        model.addAttribute("pagesNumber", customerService.getPagesNumber());
        model.addAttribute("customerList", customerService.getPageWithCustomers(pageNumber));

        return "customers/allCustomers";
    }

    @GetMapping("/search-for")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String searchFor(@RequestParam(value = "search-for") final String searchFor,
                            final Model model,
                            @RequestParam(value = "page-number", required = false, defaultValue = "0")
                                final Integer pageNumber) {
        model.addAttribute("customerList",
                customerService.getPageWithCustomersWithSearchFor(searchFor, pageNumber));
        model.addAttribute("pagesNumber", customerService.getPageNumberSearchFor());

        return "customers/allCustomers";
    }

    @GetMapping("/customer")
    @PreAuthorize("hasRole('ADMIN')")
    public String getCustomerById(final Model model,
                                  @RequestParam(value = "id") final Integer id) {
        model.addAttribute("customer", customerService.getUserById(id));

        return "customers/customer";
    }
}
