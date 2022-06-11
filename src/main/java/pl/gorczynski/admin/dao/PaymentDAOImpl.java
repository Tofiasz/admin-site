package pl.gorczynski.admin.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gorczynski.admin.model.shop.order.Payment;
import pl.gorczynski.admin.repository.shop.order.PaymentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PaymentDAOImpl{

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentDAOImpl(final PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void save(final Payment payment) {
        paymentRepository.save(payment);
    }

    public void savePaymentList() {
        getPaymentsList().forEach(this::save);
    }

    private List<Payment> getPaymentsList() {
        List<Payment> paymentList = new ArrayList<>();
        paymentList.add(new Payment("Credit/Debit card"));
        paymentList.add(new Payment("Prepaid card"));
        paymentList.add(new Payment("Bank transfer"));
        paymentList.add(new Payment("Cash"));
        paymentList.add(new Payment("Mobile payment"));

        return paymentList;
    }
}
