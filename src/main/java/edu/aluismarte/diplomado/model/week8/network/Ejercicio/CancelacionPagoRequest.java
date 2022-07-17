package edu.aluismarte.diplomado.model.week8.network.Ejercicio;

import edu.aluismarte.diplomado.model.week8.enums.PaymentProvider;
import lombok.*;

/**
 * @author aluis on 4/24/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CancelacionPagoRequest {

    private String id;
    private PaymentProvider provider;
}
