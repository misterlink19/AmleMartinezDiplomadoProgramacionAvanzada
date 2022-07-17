package edu.aluismarte.diplomado.week8;

import edu.aluismarte.diplomado.model.week8.PaypalService;
import edu.aluismarte.diplomado.model.week8.StripeService;
import edu.aluismarte.diplomado.model.week8.network.*;
import edu.aluismarte.diplomado.model.week8.network.Ejercicio.*;
import edu.aluismarte.diplomado.model.week8.network.PagoResponse;
import edu.aluismarte.diplomado.model.week8.payment.PaymentGateway;

import java.util.UUID;

/**
 * Hacer que el sistema de pago no se valide con un String, sino con un ENUM y el ENUM entregue el objeto de pago
 * <p>
 * Abstraer el sistema de pago en clases aisladas con sus propios procesos.
 *
 * @author aluis on 5/8/2022.
 * @implSpec Cambiar la constante string por el enum e el provider
 * @implSpec Hacer uso del POO para abstraer la lógica en clases y aplicar el concepto SOLID
 */
public class Exercise1Week8 {
    private final StripeService stripeService = new StripeService();
    private final PaypalService paypalService = new PaypalService();

    public PagoResponse pay(PagoRequest paymentRequest) {
        PaymentGateway proveedor = paymentRequest.getProvider().getPaymentGateway();
        String id = UUID.randomUUID().toString();
        return  PagoResponse.builder().
                id(id)
                .status(proveedor.pay(id, paymentRequest.getAmount()))
                .build();
    }

    public CancelacionPagoResponse cancel(CancelacionPagoRequest cancelPaymentRequest) {
        PaymentGateway proveedor = cancelPaymentRequest.getProvider().getPaymentGateway();
        return  CancelacionPagoResponse.builder()
                .status(proveedor.cancel(cancelPaymentRequest.getId()))
                .build();
    }

    public DevolucionPagoResponse refund(DevolucionPagoRequest devolucionPagoRequest) {
        PaymentGateway proveedor = devolucionPagoRequest.getProvider().getPaymentGateway();
        return  DevolucionPagoResponse.builder()
                .status(proveedor.pay(devolucionPagoRequest.getId(),devolucionPagoRequest.getAmount()))
                .build();
    }

}
