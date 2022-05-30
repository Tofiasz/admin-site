package pl.gorczynski.admin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gorczynski.admin.model.shop.order.Order;
import pl.gorczynski.admin.model.shop.order.Payment;
import pl.gorczynski.admin.model.shop.order.Shipper;
import pl.gorczynski.admin.model.shop.product.Product;
import pl.gorczynski.admin.model.shop.user.Customer;
import pl.gorczynski.admin.repository.shop.order.OrderRepository;
import pl.gorczynski.admin.service.shop.order.PaymentService;
import pl.gorczynski.admin.service.shop.order.ShipperService;
import pl.gorczynski.admin.service.shop.product.ProductService;
import pl.gorczynski.admin.service.user.CustomerService;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class OrderDAOImpl implements DAO<Order> {
    private final CustomerService customerService;
    private final ProductService productService;
    private final OrderRepository orderRepository;
    private final PaymentService paymentService;
    private final ShipperService shipperService;
    private final Integer ordersPerMinute = 10;
    private final Integer maxNumberOfProductsPerOrder = 3;

    @Autowired
    public OrderDAOImpl(final CustomerService customerService,
                        final ProductService productService,
                        final OrderRepository orderRepository,
                        final PaymentService paymentService,
                        final ShipperService shipperService) {
        this.customerService = customerService;
        this.productService = productService;
        this.orderRepository = orderRepository;
        this.paymentService = paymentService;
        this.shipperService = shipperService;
    }

    @Override
    public Optional<Order> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Order> getAll() {
        return new ArrayList<>();
    }

    @Override
    public void save(final Order order) {
        orderRepository.save(order);
    }

    @Override
    public void update(Order order, String[] params) {

    }

    @Override
    public void delete(Order order) {

    }

    public void createAndSaveRandomOrder() {
        for(int i = 0; i < ordersPerMinute; i++) {
            Order order = getRandomOrder();
            orderRepository.save(order);
        }
    }

    private Order getRandomOrder() {
        Order randomOrder = new Order();
        Date randomOrderDate = getRandomDate();

        randomOrder.setOrderNumber(getRandomNumber(1_000_000, 9_999_999));
        randomOrder.setOrderDate(randomOrderDate);
        randomOrder.setShipDate(getRandomDateOlderThanOrderDate(randomOrderDate));
        randomOrder.setCustomer(getRandomCustomerFromDB());

        List<Product> randomProductList = getRandomProductList();
        randomOrder.setProductList(randomProductList);
        randomOrder.setTotalPrice(getTotalPriceBasedOnProductList(randomProductList));
        randomOrder.setDiscount(0.0);
        randomOrder.setPayment(getRandomPayment());
        randomOrder.setShipper(getRandomShipper());
        randomOrder.setTransactStatus(getRandomTransactStatus());
        Boolean isPaid = getRandomBoolean();
        randomOrder.setPaid(isPaid);
        randomOrder.setPaymentDate(getRandomPaymentDate(isPaid, randomOrderDate));

        return randomOrder;
    }

    private Date getRandomPaymentDate(final Boolean isPaid,
                                      final Date randomOrderDate) {
        if (isPaid) {
            return getRandomDateOlderThanOrderDate(randomOrderDate);
        }

        return new Date();
    }

    private Boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }

    private String getRandomTransactStatus() {
        HashMap<Integer, String> transactStatus = new HashMap<>();
        transactStatus.put(1, "Delivered");
        transactStatus.put(2, "Prepared");
        transactStatus.put(3, "To be prepared");
        transactStatus.put(4, "Taken by the courier");
        transactStatus.put(5, "To be picked up");
        Integer randomNumberForPayment = getRandomNumber(1, transactStatus.size());

        return transactStatus.get(randomNumberForPayment);
    }

    private Shipper getRandomShipper() {
        List<Shipper> shipperList = shipperService.getAllShippersList();
        Integer randomShipperNumber = getRandomNumber(1, shipperList.size());

        return shipperList.get(randomShipperNumber);
    }

    private Date getRandomDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2020);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DATE, 1);
        Date dateOne = calendar.getTime();

        Date dateNow = new Date();

        return new Date(getRandomLongForDate(dateOne.getTime(), dateNow.getTime()));
    }

    private Date getRandomDateOlderThanOrderDate(final Date orderDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2022);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DATE, 1);
        Date dateTwo = calendar.getTime();

        return new Date(getRandomLongForDate(orderDate.getTime(), dateTwo.getTime()));
    }

    private Long getRandomLongForDate(final Long min,
                                      final Long max) {
       return (long) ((Math.random() * (max - min)) + min);
    }

    private Integer getRandomNumber(final Integer min,
                                    final Integer max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private Customer getRandomCustomerFromDB() {
        Integer numberOfUsers = customerService.countAllUser();
        Integer randomNumber = getRandomNumber(1, numberOfUsers);

        return customerService.getCustomerById(randomNumber);
    }

    private List<Product> getRandomProductList() {
        Integer numberOfProductsInList = getRandomNumber(1, maxNumberOfProductsPerOrder);
        List<Product> productList = new ArrayList<>();
        for(int i = 0; i <= numberOfProductsInList; i++) {
            Product randomProductFromDB = getRandomProductFromDB();
            productList.add(randomProductFromDB);
        }

        return productList;
    }

    private Product getRandomProductFromDB() {
        Integer numberOfProductsInDB = productService.countAllProducts();
        Integer getRandomNumberOfProductFromDB = getRandomNumber(1, numberOfProductsInDB);

        return productService.getProductById(getRandomNumberOfProductFromDB);
    }

    private Double getTotalPriceBasedOnProductList(final List<Product> randomProductList) {
        return randomProductList.stream().collect(Collectors.summingDouble(this::getTotalPriceOfProduct));
    }

    private Double getTotalPriceOfProduct(final Product product) {
        return product.getPrice() * (1 + product.getTax());
    }

    private Payment getRandomPayment() {
        List<Payment> paymentList = paymentService.getAllPaymentsList();
        Integer randomNumberForPayment = getRandomNumber(1, paymentList.size());

        return paymentList.get(randomNumberForPayment);
    }
}
