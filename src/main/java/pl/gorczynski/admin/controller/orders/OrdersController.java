package pl.gorczynski.admin.controller.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.gorczynski.admin.service.shop.order.OrderService;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    private final OrderService orderService;

    @Autowired
    public OrdersController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String getOrders(final Model model) {
        model.addAttribute("condition", "orders");

        return "orders/orders";
    }

    @GetMapping("/all-orders")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String getAllOrders(@RequestParam(value = "page-number", required = false, defaultValue = "0")
                               final Integer pageNumber,
                               final Model model) {
        model.addAttribute("pagesNumber", orderService.getPagesNumber());
        model.addAttribute("ordersList", orderService.getPageWithOrders(pageNumber));
        model.addAttribute("searching", false);

        return "orders/allOrders";
    }

    @GetMapping("/get-order-by-id")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String getOrderById(@RequestParam(value = "id") final Integer orderId,
                               final Model model) {
        model.addAttribute("orderDTO", orderService.getOrderDTOById(orderId));

        return "orders/order";
    }

    @GetMapping("/delete-order-by-id")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteOrderById(@RequestParam(value = "id") final Integer orderId) {
        orderService.deleteOrderById(orderId);
        return "redirect:/orders/all-orders";
    }
}
