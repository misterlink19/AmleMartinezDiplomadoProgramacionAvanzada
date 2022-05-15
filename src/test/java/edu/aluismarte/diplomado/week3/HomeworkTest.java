package edu.aluismarte.diplomado.week3;

import edu.aluismarte.diplomado.model.week3.FrequencyType;
import edu.aluismarte.diplomado.model.week3.Loan;
import edu.aluismarte.diplomado.model.week3.LoanType;
import edu.aluismarte.diplomado.model.week3.Quote;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Aqui deben escribir los test para cubrir la clase correspondiente
 * <p>
 * Debe tener un 100% Coverage
 *
 * @author aluis on 5/1/2022.
 */
public class HomeworkTest {

    private final Homework homework = new Homework();
    private final Loan prestamo = new Loan();


    /**
     * Con esta función siempre compararás las cuotas.
     * <p>
     * Puedes usar un ciclo for comparando la cada cuota con esta función para que valides que son iguales
     *
     * @param quoteExpected La esperada y con los valores que debería arroja la actual
     * @param quoteActual   La generada por la función
     */
    private void compareQuotes(Quote quoteExpected, Quote quoteActual) {
        assertEquals(quoteExpected.getDate(), quoteActual.getDate());
        assertEquals(quoteExpected.getAmount(), quoteActual.getAmount());
    }

    /**
     * Método de ayuda para generar las quotas.
     *
     * @param date   Fecha
     * @param amount Monto
     * @return cuota esperada
     */
    private Quote createQuote(LocalDate date, BigDecimal amount) {
        return Quote.builder().date(date).amount(amount).build();
    }
    @Test
    void casoLoanElTipoDeLoanEsNull() {
        assertNull(homework.calculateQuotes(null));
    }
    @Test
    void casoLoanTieneTodosSusAtributosNull() {
        assertEquals(homework.calculateQuotes(prestamo),new ArrayList<>());
    }
    @Test
    void casoLoanDuelvePagosARealizarConFIXEDMensual() {
        prestamo.setCapital( new BigDecimal(1000));
        prestamo.setQuotes(4);
        prestamo.setFrequencyType(FrequencyType.MONTHLY);
        prestamo.setStartDate(LocalDate.now());
        prestamo.setLoanType(LoanType.FIXED);
        prestamo.setInterest(new BigDecimal(80));

        for (Quote quote: homework.calculateQuotes(prestamo)
             ) {
            compareQuotes(quote,createQuote(quote.getDate(),quote.getAmount() ));
        }
    }
    @Test
    void casoLoanDuelvePagosARealizarConFIXEDSemanal() {
        prestamo.setCapital( new BigDecimal(4000));
        prestamo.setQuotes(8);
        prestamo.setFrequencyType(FrequencyType.WEEKLY);
        prestamo.setStartDate(LocalDate.now());
        prestamo.setLoanType(LoanType.FIXED);
        prestamo.setInterest(new BigDecimal(120));

        for (Quote quote: homework.calculateQuotes(prestamo)
        ) {
            compareQuotes(quote,createQuote(quote.getDate(),quote.getAmount() ));
        }
    }
    @Test
    void casoLoanDuelvePagosARealizarConFIXEDDiario() {
        prestamo.setCapital( new BigDecimal(2500));
        prestamo.setQuotes(15);
        prestamo.setFrequencyType(FrequencyType.DAILY);
        prestamo.setStartDate(LocalDate.now());
        prestamo.setLoanType(LoanType.FIXED);
        prestamo.setInterest(new BigDecimal(60));

        for (Quote quote: homework.calculateQuotes(prestamo)
        ) {
            compareQuotes(quote,createQuote(quote.getDate(),quote.getAmount() ));
        }
    }
    @Test
    void casoLoanDuelvePagosARealizarConSANMensual() {
        prestamo.setCapital( new BigDecimal(10000));
        prestamo.setQuotes(4);
        prestamo.setFrequencyType(FrequencyType.MONTHLY);
        prestamo.setStartDate(LocalDate.now());
        prestamo.setLoanType(LoanType.SAN);
        prestamo.setInterest(new BigDecimal(1000));

        for (Quote quote: homework.calculateQuotes(prestamo)
        ) {
            compareQuotes(quote,createQuote(quote.getDate(),quote.getAmount() ));
        }
    }
    @Test
    void casoLoanDuelvePagosARealizarConSANSemanal() {
        prestamo.setCapital( new BigDecimal(4000));
        prestamo.setQuotes(8);
        prestamo.setFrequencyType(FrequencyType.WEEKLY);
        prestamo.setStartDate(LocalDate.now());
        prestamo.setLoanType(LoanType.SAN);
        prestamo.setInterest(new BigDecimal(120));

        for (Quote quote: homework.calculateQuotes(prestamo)
        ) {
            compareQuotes(quote,createQuote(quote.getDate(),quote.getAmount() ));
        }
    }
    @Test
    void casoLoanDuelvePagosARealizarConSANDiario() {
        prestamo.setCapital( new BigDecimal(2500));
        prestamo.setQuotes(15);
        prestamo.setFrequencyType(FrequencyType.DAILY);
        prestamo.setStartDate(LocalDate.now());
        prestamo.setLoanType(LoanType.SAN);
        prestamo.setInterest(new BigDecimal(60));

        for (Quote quote: homework.calculateQuotes(prestamo)
        ) {
            compareQuotes(quote,createQuote(quote.getDate(),quote.getAmount() ));
        }
    }

    @Test
    void casoCuandoLaCantidadDeCuotasEsCeroConSAN() {
        prestamo.setCapital( new BigDecimal(2500));
        prestamo.setQuotes(0);
        prestamo.setFrequencyType(FrequencyType.DAILY);
        prestamo.setStartDate(LocalDate.now());
        prestamo.setLoanType(LoanType.SAN);
        prestamo.setInterest(new BigDecimal(60));

        for (Quote quote: homework.calculateQuotes(prestamo)
        ) {
            compareQuotes(quote,createQuote(quote.getDate(),quote.getAmount() ));
        }
    }
    @Test
    void casoCuandoLaCantidadDeCuotasEsCeroConFIXED() {
        prestamo.setCapital( new BigDecimal(2500));
        prestamo.setQuotes(0);
        prestamo.setFrequencyType(FrequencyType.DAILY);
        prestamo.setStartDate(LocalDate.now());
        prestamo.setLoanType(LoanType.FIXED);
        prestamo.setInterest(new BigDecimal(60));

        for (Quote quote: homework.calculateQuotes(prestamo)
        ) {
            compareQuotes(quote,createQuote(quote.getDate(),quote.getAmount() ));
        }
    }
    @Test
    void casoCuandoLaCantidadDeCuotasEsNegativoConSAN() {
        prestamo.setCapital( new BigDecimal(2500));
        prestamo.setQuotes(-1);
        prestamo.setFrequencyType(FrequencyType.DAILY);
        prestamo.setStartDate(LocalDate.now());
        prestamo.setLoanType(LoanType.SAN);
        prestamo.setInterest(new BigDecimal(60));

        for (Quote quote: homework.calculateQuotes(prestamo)
        ) {
            compareQuotes(quote,createQuote(quote.getDate(),quote.getAmount() ));
        }
    }
}
