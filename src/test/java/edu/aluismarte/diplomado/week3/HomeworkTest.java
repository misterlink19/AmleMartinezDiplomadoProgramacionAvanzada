package edu.aluismarte.diplomado.week3;

import edu.aluismarte.diplomado.model.week3.FrequencyType;
import edu.aluismarte.diplomado.model.week3.Loan;
import edu.aluismarte.diplomado.model.week3.LoanType;
import edu.aluismarte.diplomado.model.week3.Quote;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Aqui deben escribir los test para cubrir la clase correspondiente
 * <p>
 * Debe tener un 100% Coverage
 *
 * @author aluis on 5/1/2022.
 */
public class HomeworkTest {

    private final Homework homework = new Homework();

    @Nested
    class DataValidationTest {

        @Test
        void nullDataTest() {
            assertNull(homework.calculateQuotes(null));
        }

        @Test
        void nullLoanTypeTest() {
            Loan loan = Loan.builder()
                    .loanType(null)
                    .build();
            List<Quote> quotes = homework.calculateQuotes(loan);
            assertNotNull(quotes);
            assertEquals(0, quotes.size());
        }

        @Test
        void nullFrequencyTypeTest() {
            Loan loan = Loan.builder()
                    .loanType(LoanType.FIXED)
                    .frequencyType(null)
                    .build();
            List<Quote> quotes = homework.calculateQuotes(loan);
            assertNotNull(quotes);
            assertEquals(0, quotes.size());
        }

        @Test
        void nullCapitalTest() {
            Loan loan = Loan.builder()
                    .loanType(LoanType.FIXED)
                    .frequencyType(FrequencyType.DAILY)
                    .capital(null)
                    .build();
            List<Quote> quotes = homework.calculateQuotes(loan);
            assertNotNull(quotes);
            assertEquals(0, quotes.size());
        }

        @Test
        void nullQuotesTest() {
            Loan loan = Loan.builder()
                    .loanType(LoanType.FIXED)
                    .frequencyType(FrequencyType.DAILY)
                    .capital(new BigDecimal(100))
                    .quotes(null)
                    .build();
            List<Quote> quotes = homework.calculateQuotes(loan);
            assertNotNull(quotes);
            assertEquals(0, quotes.size());
        }

        @Test
        void nullInterestTest() {
            Loan loan = Loan.builder()
                    .loanType(LoanType.FIXED)
                    .frequencyType(FrequencyType.DAILY)
                    .capital(new BigDecimal(100))
                    .quotes(2)
                    .interest(null)
                    .build();
            List<Quote> quotes = homework.calculateQuotes(loan);
            assertNotNull(quotes);
            assertEquals(0, quotes.size());
        }

        @Test
        void nullStartDateTest() {
            Loan loan = Loan.builder()
                    .loanType(LoanType.FIXED)
                    .frequencyType(FrequencyType.DAILY)
                    .capital(new BigDecimal(100))
                    .quotes(2)
                    .interest(new BigDecimal(10))
                    .startDate(null)
                    .build();
            List<Quote> quotes = homework.calculateQuotes(loan);
            assertNotNull(quotes);
            assertEquals(0, quotes.size());
        }
    }

    @Nested
    class SimpleFixedCaseTest {

        @Test
        void daily2QuotesTest() {
            List<Quote> expectedQuotes = new ArrayList<>();
            expectedQuotes.add(createQuote(LocalDate.of(2021, Month.JANUARY, 2),
                    new BigDecimal("600.00")));
            expectedQuotes.add(createQuote(LocalDate.of(2021, Month.JANUARY, 3),
                    new BigDecimal("600.00")));
            Loan loan = Loan.builder()
                    .loanType(LoanType.FIXED)
                    .frequencyType(FrequencyType.DAILY)
                    .capital(new BigDecimal(1000))
                    .quotes(2)
                    .interest(new BigDecimal(100))
                    .startDate(LocalDate.of(2021, Month.JANUARY, 1))
                    .build();
            List<Quote> quotes = homework.calculateQuotes(loan);
            assertNotNull(quotes);
            assertEquals(2, quotes.size());
            for (int i = 0; i < quotes.size(); i++) {
                compareQuotes(expectedQuotes.get(i), quotes.get(i));
            }
        }

        @Test
        void weekly2QuotesTest() {
            List<Quote> expectedQuotes = new ArrayList<>();
            expectedQuotes.add(createQuote(LocalDate.of(2021, Month.JANUARY, 8),
                    new BigDecimal("600.00")));
            expectedQuotes.add(createQuote(LocalDate.of(2021, Month.JANUARY, 15),
                    new BigDecimal("600.00")));
            Loan loan = Loan.builder()
                    .loanType(LoanType.FIXED)
                    .frequencyType(FrequencyType.WEEKLY)
                    .capital(new BigDecimal(1000))
                    .quotes(2)
                    .interest(new BigDecimal(100))
                    .startDate(LocalDate.of(2021, Month.JANUARY, 1))
                    .build();
            List<Quote> quotes = homework.calculateQuotes(loan);
            assertNotNull(quotes);
            assertEquals(2, quotes.size());
            for (int i = 0; i < quotes.size(); i++) {
                compareQuotes(expectedQuotes.get(i), quotes.get(i));
            }
        }

        @Test
        void monthly2QuotesTest() {
            List<Quote> expectedQuotes = new ArrayList<>();
            expectedQuotes.add(createQuote(LocalDate.of(2021, Month.FEBRUARY, 1),
                    new BigDecimal("600.00")));
            expectedQuotes.add(createQuote(LocalDate.of(2021, Month.MARCH, 1),
                    new BigDecimal("600.00")));
            Loan loan = Loan.builder()
                    .loanType(LoanType.FIXED)
                    .frequencyType(FrequencyType.MONTHLY)
                    .capital(new BigDecimal(1000))
                    .quotes(2)
                    .interest(new BigDecimal(100))
                    .startDate(LocalDate.of(2021, Month.JANUARY, 1))
                    .build();
            List<Quote> quotes = homework.calculateQuotes(loan);
            assertNotNull(quotes);
            assertEquals(2, quotes.size());
            for (int i = 0; i < quotes.size(); i++) {
                compareQuotes(expectedQuotes.get(i), quotes.get(i));
            }
        }
    }

    @Nested
    class SimpleSanCaseTest {

        @Test
        void daily2QuotesTest() {
            List<Quote> expectedQuotes = new ArrayList<>();
            expectedQuotes.add(createQuote(LocalDate.of(2021, Month.JANUARY, 2),
                    new BigDecimal("550.00")));
            expectedQuotes.add(createQuote(LocalDate.of(2021, Month.JANUARY, 3),
                    new BigDecimal("550.00")));
            Loan loan = Loan.builder()
                    .loanType(LoanType.SAN)
                    .frequencyType(FrequencyType.DAILY)
                    .capital(new BigDecimal(1000))
                    .quotes(2)
                    .interest(new BigDecimal(100))
                    .startDate(LocalDate.of(2021, Month.JANUARY, 1))
                    .build();
            List<Quote> quotes = homework.calculateQuotes(loan);
            assertNotNull(quotes);
            assertEquals(2, quotes.size());
            for (int i = 0; i < quotes.size(); i++) {
                compareQuotes(expectedQuotes.get(i), quotes.get(i));
            }
        }

        @Test
        void weekly2QuotesTest() {
            List<Quote> expectedQuotes = new ArrayList<>();
            expectedQuotes.add(createQuote(LocalDate.of(2021, Month.JANUARY, 8),
                    new BigDecimal("550.00")));
            expectedQuotes.add(createQuote(LocalDate.of(2021, Month.JANUARY, 15),
                    new BigDecimal("550.00")));
            Loan loan = Loan.builder()
                    .loanType(LoanType.SAN)
                    .frequencyType(FrequencyType.WEEKLY)
                    .capital(new BigDecimal(1000))
                    .quotes(2)
                    .interest(new BigDecimal(100))
                    .startDate(LocalDate.of(2021, Month.JANUARY, 1))
                    .build();
            List<Quote> quotes = homework.calculateQuotes(loan);
            assertNotNull(quotes);
            assertEquals(2, quotes.size());
            for (int i = 0; i < quotes.size(); i++) {
                compareQuotes(expectedQuotes.get(i), quotes.get(i));
            }
        }

        @Test
        void monthly2QuotesTest() {
            List<Quote> expectedQuotes = new ArrayList<>();
            expectedQuotes.add(createQuote(LocalDate.of(2021, Month.FEBRUARY, 1),
                    new BigDecimal("550.00")));
            expectedQuotes.add(createQuote(LocalDate.of(2021, Month.MARCH, 1),
                    new BigDecimal("550.00")));
            Loan loan = Loan.builder()
                    .loanType(LoanType.SAN)
                    .frequencyType(FrequencyType.MONTHLY)
                    .capital(new BigDecimal(1000))
                    .quotes(2)
                    .interest(new BigDecimal(100))
                    .startDate(LocalDate.of(2021, Month.JANUARY, 1))
                    .build();
            List<Quote> quotes = homework.calculateQuotes(loan);
            assertNotNull(quotes);
            assertEquals(2, quotes.size());
            for (int i = 0; i < quotes.size(); i++) {
                compareQuotes(expectedQuotes.get(i), quotes.get(i));
            }
        }
    }

    @Test
    void negativeQuoteTest() {
        Loan loan = Loan.builder()
                .loanType(LoanType.SAN)
                .frequencyType(FrequencyType.DAILY)
                .capital(new BigDecimal(1000))
                .quotes(-2)
                .interest(new BigDecimal(100))
                .startDate(LocalDate.of(2021, Month.JANUARY, 1))
                .build();
        List<Quote> quotes = homework.calculateQuotes(loan);
        assertNotNull(quotes);
        assertTrue(quotes.isEmpty());
    }

    @Nested
    class BugTest {

        /**
         * Caso reportado por @fulado, enero 2015 el usuario etc...
         * mirar correo anexo en carpeta X
         */
        @Test
        void case2015NullOnLalalaTest() {
        }

    }

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
}
