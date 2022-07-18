package edu.aluismarte.diplomado.project.week9.service;

import edu.aluismarte.diplomado.project.domain.Payment;
import edu.aluismarte.diplomado.project.repositories.PaymentRepository;
import edu.aluismarte.diplomado.project.week9.network.dto.PaymentDTO;
import edu.aluismarte.diplomado.project.week9.network.request.CreatePaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author aluis on 6/26/2022.
 */
@RequiredArgsConstructor
@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public List<PaymentDTO> getPayments() {
        return paymentRepository.findAll().stream().map(Payment::toDTO).collect(Collectors.toList());
    }

    public PaymentDTO createPayment(CreatePaymentRequest createPaymentRequest) {
        Payment payment = createPaymentRequest.toNewPayment();
        paymentRepository.save(payment);
        return payment.toDTO();
    }

}
