package pl.gorczynski.admin.controller.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gorczynski.admin.service.shop.order.OrderService;
import pl.gorczynski.admin.service.shop.product.ProductService;
import pl.gorczynski.admin.service.user.CustomerService;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private final CustomerService customerService;
    private final ProductService productService;
    private final OrderService orderService;

    @Autowired
    public DashboardController(final CustomerService customerService,
                               final ProductService productService,
                               final OrderService orderService) {
        this.customerService = customerService;
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String getDashboard(final Model model) {
        model.addAttribute("condition", "dashboard");
        model.addAttribute("last12Months", orderService.getEarningsPerMonthList());
        model.addAttribute("earningsThisYear", orderService.getEarningsCurrentYear());
        model.addAttribute("topBuyersList", orderService.getTopBuyersList());
        model.addAttribute("numberOfOrdersInCurrentMonth", orderService.getNumberOfOrdersInCurrentMonth());
        model.addAttribute("numberOfProducts", productService.countAllProducts());
        model.addAttribute("numberOfUsers", customerService.countAllUser());
        model.addAttribute("tenRecentRegisteredCustomers",
                customerService.getCustomerDTOListAsc(10, 0));

        return "dashboard/dashboard";
    }
}
