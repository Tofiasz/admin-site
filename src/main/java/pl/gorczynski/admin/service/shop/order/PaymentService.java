package pl.gorczynski.admin.service.shop.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gorczynski.admin.model.shop.order.Payment;
import pl.gorczynski.admin.repository.shop.order.PaymentRepository;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(final PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Integer getNumberOfPayments() {
        return Math.toIntExact(paymentRepository.count());
    }

    public List<Payment> getAllPaymentsList() {
        return paymentRepository.findAll();
    }
}
