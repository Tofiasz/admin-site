package pl.gorczynski.admin.mapper.order;

import org.springframework.stereotype.Component;
import pl.gorczynski.admin.dto.order.PaymentDTO;
import pl.gorczynski.admin.model.shop.order.Payment;

@Component
public class PaymentMapper {

    public PaymentDTO toPaymentDTO(final Payment payment) {
        return new PaymentDTO(payment.getId(),
                payment.getPaymentType());
    }

    public Payment toPayment(final PaymentDTO paymentDTO) {
        return new Payment(paymentDTO.getId(),
                paymentDTO.getPaymentType());
    }
}
