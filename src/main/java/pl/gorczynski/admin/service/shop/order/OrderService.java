package pl.gorczynski.admin.service.shop.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.gorczynski.admin.dao.OrderDAOImpl;
import pl.gorczynski.admin.dao.PaymentDAOImpl;
import pl.gorczynski.admin.dao.ShipperDAOImpl;
import pl.gorczynski.admin.dto.order.OrderDTO;
import pl.gorczynski.admin.mapper.order.OrderMapper;
import pl.gorczynski.admin.model.shop.order.Order;
import pl.gorczynski.admin.repository.shop.order.OrderRepository;
import pl.gorczynski.admin.repository.shop.order.TopBuyers;

import java.text.DateFormatSymbols;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderDAOImpl orderDAO;
    private final PaymentDAOImpl paymentDAO;
    private final ShipperDAOImpl shipperDAO;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderService(final OrderRepository orderRepository,
                        final OrderDAOImpl orderDAO,
                        final PaymentDAOImpl paymentDAO,
                        final ShipperDAOImpl shipperDAO,
                        final OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderDAO = orderDAO;
        this.paymentDAO = paymentDAO;
        this.shipperDAO = shipperDAO;
        this.orderMapper = orderMapper;
    }

    @Bean
    private void saveShippersAndPaymentTypes() {
        shipperDAO.saveShippersList();
        paymentDAO.savePaymentList();
    }

    @Scheduled(fixedRate = 60_000)
    private void saveNewOrders() {
        orderDAO.createAndSaveRandomOrder();
    }

    public List<TopBuyers> getTopBuyersList() {
        return orderRepository.findTop5Buyers();
    }
    public Integer getEarningsCurrentYear() {
        Calendar calendarCurrentDate = getCurrentDate();
        setTimeToBeginningOfYear(calendarCurrentDate);
        Date dateFrom = calendarCurrentDate.getTime();
        calendarCurrentDate = getCurrentDate();
        setTimeToEndOfMonth(calendarCurrentDate);
        Date dateTo = calendarCurrentDate.getTime();

        return orderRepository.getEarningsCurrentYear(dateFrom, dateTo);
    }

    private static void setTimeToBeginningOfYear(final Calendar calendar) {
        setTimeToBeginningOfMonth(calendar);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
    }

    public Integer getNumberOfOrdersInCurrentMonth() {
        Calendar calendarCurrentDate = getCurrentDate();
        setTimeToBeginningOfMonth(calendarCurrentDate);
        Date dateFrom = calendarCurrentDate.getTime();
        setTimeToEndOfMonth(calendarCurrentDate);
        Date dateTo = calendarCurrentDate.getTime();

        return orderRepository.countAllOrdersBetweenDatesRange(dateFrom, dateTo);
    }

    private static Calendar getCurrentDate() {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(new Date());

        return calendar;
    }

    private static void setTimeToBeginningOfMonth(final Calendar calendar) {
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    private static void setTimeToEndOfMonth(final Calendar calendar) {
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
    }

    public List<Integer> getLastTwelveMonths() {
        List<Integer> lastTwelveMonthsList = new ArrayList<>();
        Calendar calendar = getCurrentDate();
        Integer month = calendar.get(Calendar.MONTH);

        for(int i = 11; i >= 0; i--) {
            Integer monthToAdd = month - i;
            if (monthToAdd < 0) {
                monthToAdd += 12;
                monthToAdd *= -1;
                lastTwelveMonthsList.add(monthToAdd);
            }
            else {
                lastTwelveMonthsList.add(monthToAdd);
            }
        }
        return lastTwelveMonthsList;
    }

    public Integer getEarningsPerMonth(final Integer month) {
        Calendar calendar = getCurrentDate();
        setTimeToBeginningOfMonth(calendar);
        Calendar calendarFrom = calendar;
        calendar = getCurrentDate();
        setTimeToEndOfMonth(calendar);
        Calendar calendarTo = calendar;
        Integer monthEarnings;
        if (month < 0) {
            calendarFrom.set(Calendar.MONTH, Math.abs(month));
            calendarFrom.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
            calendarTo.set(Calendar.MONTH, Math.abs(month));
            calendarTo.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
            Date dateFrom = calendarFrom.getTime();
            Date dateTo = calendarTo.getTime();
            monthEarnings = orderRepository.getEarningsBetweenDates(dateFrom, dateTo);

            return monthEarnings == null ? 0 : monthEarnings;
        }
        calendarFrom.set(Calendar.MONTH, Math.abs(month));
        calendarTo.set(Calendar.MONTH, Math.abs(month));
        Date dateFrom = calendarFrom.getTime();
        Date dateTo = calendarTo.getTime();
        monthEarnings = orderRepository.getEarningsBetweenDates(dateFrom, dateTo);

        return monthEarnings == null ? 0 : monthEarnings;
    }

    public List<Integer> getEarningList() {
        return getLastTwelveMonths().stream().map(this::getEarningsPerMonth).collect(Collectors.toList());
    }

    public List<String> getLastTwelveMonthsNames() {
        return getLastTwelveMonths().stream()
                .map(this::getMonthForInt)
                .collect(Collectors.toList());
    }

    public String getMonthForInt(Integer monthNumber) {
        DateFormatSymbols dfs = new DateFormatSymbols(Locale.ENGLISH);
        String[] months = dfs.getMonths();
        monthNumber = Math.abs(monthNumber);

        return months[monthNumber];
    }
    public List<List<Object>> getEarningsPerMonthList() {
        List<String> monthsList = getLastTwelveMonthsNames();
        List<Integer> earningsList = getEarningList();

        return List.of(List.of("Month", "Earnings"),
                List.of(monthsList.get(0), earningsList.get(0)),
                List.of(monthsList.get(1), earningsList.get(1)),
                List.of(monthsList.get(2), earningsList.get(2)),
                List.of(monthsList.get(3), earningsList.get(3)),
                List.of(monthsList.get(4), earningsList.get(4)),
                List.of(monthsList.get(5), earningsList.get(5)),
                List.of(monthsList.get(6), earningsList.get(6)),
                List.of(monthsList.get(7), earningsList.get(7)),
                List.of(monthsList.get(8), earningsList.get(8)),
                List.of(monthsList.get(9), earningsList.get(9)),
                List.of(monthsList.get(10), earningsList.get(10)),
                List.of(monthsList.get(11), earningsList.get(11)));
    }

    public List<OrderDTO> getPageWithOrders(final Integer pageNumber) {
        List<Order> orderList = orderRepository.findAll(PageRequest.of(pageNumber, 10)).toList();

        return orderMapper.toOrderDTOList(orderList);
    }

    public Integer getPagesNumber() {
        return (int) Math.ceil(orderRepository.count() / 10.0);
    }

    public OrderDTO getOrderDTOById(final Integer orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();

        return orderMapper.toOrderDTO(order);
    }

    public void deleteOrderById(final Integer orderId) {
        orderRepository.deleteById(orderId);
    }
}
