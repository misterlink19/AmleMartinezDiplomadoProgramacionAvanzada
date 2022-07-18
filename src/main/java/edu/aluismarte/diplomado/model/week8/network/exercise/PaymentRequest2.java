package edu.aluismarte.diplomado.model.week8.network.exercise;

import edu.aluismarte.diplomado.model.week8.enums.PaymentProvider;
import lombok.*;

import java.math.BigDecimal;

/**
 * @author aluis on 6/26/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PaymentRequest2 {

    private PaymentProvider provider;
    private BigDecimal amount;
}
