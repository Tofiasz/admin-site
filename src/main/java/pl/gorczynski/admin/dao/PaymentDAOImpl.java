package pl.gorczynski.admin.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gorczynski.admin.model.shop.order.Payment;
import pl.gorczynski.admin.repository.shop.order.PaymentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PaymentDAOImpl implements DAO<Payment> {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentDAOImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Optional<Payment> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Payment> getAll() {
        return null;
    }

    @Override
    public void save(final Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void update(Payment payment, String[] params) {

    }

    @Override
    public void delete(Payment payment) {

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
