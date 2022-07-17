package edu.aluismarte.diplomado.week8;

import edu.aluismarte.diplomado.model.week8.PaypalService;
import edu.aluismarte.diplomado.model.week8.StripeService;
import edu.aluismarte.diplomado.model.week8.network.*;
import edu.aluismarte.diplomado.model.week8.network.Ejercicio.CancelacionPagoResponse;
import edu.aluismarte.diplomado.model.week8.network.Ejercicio.DevolucionPagoResponse;

import java.util.UUID;

/**
 * Implementación común de un sistema de pago con multiples proveedores
 * <p>
 * Esta forma es de un novato y demuestra que no se sabe usar el concepto de objetos y delegación de responsabilidad del SOLID
 *
 * @author aluis on 4/24/2022.
 */
public class SimplePaymentImplementation {

    private final StripeService stripeService = new StripeService();
    private final PaypalService paypalService = new PaypalService();

    public PagoResponse pay(PaymentRequest paymentRequest) {
        PagoResponse paymentResponse = PagoResponse.builder().id(UUID.randomUUID().toString()).build();
        switch (paymentRequest.getProvider()) {
            case "STRIPE" ->
                    paymentResponse.setStatus(stripeService.pay(paymentResponse.getId(), paymentRequest.getAmount()));
            case "PAYPAL" ->
                    paymentResponse.setStatus(paypalService.pay(paymentResponse.getId(), paymentRequest.getAmount()));
            default -> paymentResponse.setId(null);
        }
        return paymentResponse;
    }

    public CancelacionPagoResponse cancel(CancelPaymentRequest cancelPaymentRequest) {
        CancelacionPagoResponse cancelPaymentResponse = CancelacionPagoResponse.builder().build();
        switch (cancelPaymentRequest.getProvider()) {
            case "STRIPE" -> cancelPaymentResponse.setStatus(stripeService.cancel(cancelPaymentRequest.getId()));
            case "PAYPAL" -> cancelPaymentResponse.setStatus(paypalService.cancel(cancelPaymentRequest.getId()));
        }
        return cancelPaymentResponse;
    }

    public DevolucionPagoResponse refund(RefundPaymentRequest refundPaymentRequest) {
        DevolucionPagoResponse refundPaymentResponse = DevolucionPagoResponse.builder().build();
        switch (refundPaymentRequest.getProvider()) {
            case "STRIPE" ->
                    refundPaymentResponse.setStatus(stripeService.refund(refundPaymentRequest.getId(), refundPaymentRequest.getAmount()));
            case "PAYPAL" ->
                    refundPaymentResponse.setStatus(paypalService.refund(refundPaymentRequest.getId(), refundPaymentRequest.getAmount()));
        }
        return refundPaymentResponse;
    }
}
