package edu.aluismarte.diplomado.week8;

import edu.aluismarte.diplomado.model.week8.network.exercise.*;
import edu.aluismarte.diplomado.model.week8.payment.PaymentGateway;

import java.util.UUID;

/**
 * Hacer que el sistema de pago no se valide con un String, sino con un ENUM y el ENUM entregue el objeto de pago
 * <p>
 * Abstraer el sistema de pago en clases aisladas con sus propios procesos.
 *
 * @author aluis on 5/8/2022.
 * @implSpec Cambiar la constante string por el enum en el provider
 * @implSpec Hacer uso del POO para abstraer la lógica en clases y aplicar el concepto SOLID
 */
public class Exercise1Week8 {

    public PaymentResponse2 pay(PaymentRequest2 paymentRequest) {
        PaymentGateway provider = paymentRequest.getProvider().getPaymentGateway();
        String id = UUID.randomUUID().toString();
        return PaymentResponse2.builder()
                .id(id)
                .status(provider.pay(id, paymentRequest.getAmount()))
                .build();
    }

    public CancelPaymentResponse2 cancel(CancelPaymentRequest2 cancelPaymentRequest) {
        PaymentGateway provider = cancelPaymentRequest.getProvider().getPaymentGateway();
        return CancelPaymentResponse2.builder()
                .status(provider.cancel(cancelPaymentRequest.getId()))
                .build();
    }

    public RefundPaymentResponse2 refund(RefundPaymentRequest2 refundPaymentRequest) {
        PaymentGateway provider = refundPaymentRequest.getProvider().getPaymentGateway();
        return RefundPaymentResponse2.builder()
                .status(provider.refund(refundPaymentRequest.getId(), refundPaymentRequest.getAmount()))
                .build();
    }
}
