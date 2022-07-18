package edu.aluismarte.diplomado.model.week8.enums;

import edu.aluismarte.diplomado.model.week8.MastercardService;
import edu.aluismarte.diplomado.model.week8.PaypalService;
import edu.aluismarte.diplomado.model.week8.VisaService;
import edu.aluismarte.diplomado.model.week8.payment.PaymentGateway;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author aluis on 6/26/2022.
 */
@RequiredArgsConstructor
public enum PaymentProvider {
    STRIPE(new VisaService()),
    PAYPAL(new PaypalService()),
    MASTERCARD(new MastercardService()),
    VISA(new VisaService());

    @Getter
    private final PaymentGateway paymentGateway;

}
