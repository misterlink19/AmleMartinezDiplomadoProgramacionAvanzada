package edu.aluismarte.diplomado.model.week8.enums;

import edu.aluismarte.diplomado.model.week8.PaypalService;
import edu.aluismarte.diplomado.model.week8.StripeService;
import edu.aluismarte.diplomado.model.week8.payment.PaymentGateway;
import lombok.Getter;
import lombok.SneakyThrows;

import java.math.BigDecimal;

public enum PaymentProvider {
    STRIPE, PAYPAL, VISA, MASTERCARD;

    @Getter
    private final PaymentGateway paymentGateway;

    PaymentProvider() {
        paymentGateway = null;
    }

    @SneakyThrows
    public String pago(String id, BigDecimal amount) {
        return switch (this) {
            case STRIPE -> StripeService.class.newInstance().pay(id, amount);
            case PAYPAL -> PaypalService.class.newInstance().pay(id, amount);
            case VISA -> PaypalService.class.newInstance().pay(id, amount);
            case MASTERCARD -> PaypalService.class.newInstance().pay(id, amount);

        };

    }

    @SneakyThrows
    public String cancelar(String id) {
        return switch (this) {
            case STRIPE -> StripeService.class.newInstance().cancel(id);
            case PAYPAL -> PaypalService.class.newInstance().cancel(id);
            case VISA -> PaypalService.class.newInstance().cancel(id);
            case MASTERCARD -> PaypalService.class.newInstance().cancel(id);
        };
    }

    @SneakyThrows
    public String devolucionar(String id, BigDecimal amount) {
        return switch (this) {
            case STRIPE -> StripeService.class.newInstance().refund(id, amount);
            case PAYPAL -> PaypalService.class.newInstance().refund(id, amount);
            case VISA -> PaypalService.class.newInstance().refund(id, amount);
            case MASTERCARD -> PaypalService.class.newInstance().refund(id, amount);
        };
    }
}
