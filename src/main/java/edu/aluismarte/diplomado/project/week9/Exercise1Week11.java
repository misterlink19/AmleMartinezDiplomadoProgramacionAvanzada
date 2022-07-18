package edu.aluismarte.diplomado.project.week9;

import edu.aluismarte.diplomado.project.week9.network.request.CreatePaymentRequest;
import edu.aluismarte.diplomado.project.week9.network.response.CreatePaymentResponse;
import edu.aluismarte.diplomado.project.week9.network.response.GetPaymentsResponse;
import edu.aluismarte.diplomado.project.week9.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Debemos aplicar el factory, los DTO al Payment
 * <p>
 * Se harán 2 endpoint:
 * - Listar los pagos
 * - Hacer un pago
 *
 * @author aluis on 6/4/2022.
 * @implNote Deben usar el patrón adecuado para cada tarea
 */
@RestController
@RequiredArgsConstructor
public class Exercise1Week11 {

    private final PaymentService paymentService;

    @GetMapping("/fill")
    public ResponseEntity<String> fill() {
        paymentService.createPayment(CreatePaymentRequest.builder().amount(new BigDecimal(15)).build());
        paymentService.createPayment(CreatePaymentRequest.builder().amount(new BigDecimal(25)).build());
        paymentService.createPayment(CreatePaymentRequest.builder().amount(new BigDecimal(100)).build());
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/exercise")
    public ResponseEntity<GetPaymentsResponse> getPayments() {
        return ResponseEntity.ok(GetPaymentsResponse.builder()
                .payments(paymentService.getPayments())
                .build());
    }

    @PostMapping("/exercise")
    public ResponseEntity<CreatePaymentResponse> createPayment(@RequestBody CreatePaymentRequest createPaymentRequest) {
        return ResponseEntity.ok(CreatePaymentResponse.builder()
                .payment(paymentService.createPayment(createPaymentRequest))
                .build());
    }

}
