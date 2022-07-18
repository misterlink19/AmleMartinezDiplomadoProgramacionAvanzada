package edu.aluismarte.diplomado.project.week9.network.request;

import edu.aluismarte.diplomado.project.domain.Payment;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author aluis on 6/26/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreatePaymentRequest {

    private BigDecimal amount;

    public Payment toNewPayment() {
        LocalDateTime now = LocalDateTime.now();
        return Payment.builder()
                .id(UUID.randomUUID())
                .amount(amount)
                .createdBy("Server")
                .createdAt(now)
                .updatedBy("Server")
                .updatedAt(now)
                .build();
    }
}
