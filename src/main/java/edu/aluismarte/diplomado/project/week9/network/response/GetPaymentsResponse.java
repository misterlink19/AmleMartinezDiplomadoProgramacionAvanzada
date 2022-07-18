package edu.aluismarte.diplomado.project.week9.network.response;

import edu.aluismarte.diplomado.project.week9.network.dto.PaymentDTO;
import lombok.*;

import java.util.List;

/**
 * @author aluis on 7/3/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetPaymentsResponse {

    private List<PaymentDTO> payments;
}
