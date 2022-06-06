package edu.aluismarte.diplomado.week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aluis on 5/8/2022.
 */
class Exercise1Week3Test {

    private static final String NUMEROS_PARA_FIZZBUZZ = "/NumerosParaFizzBuzz.csv";
    private static final String NUMEROS_PARA_FIZZ = "/NumerosParaFizz.csv";
    private static final String NUMEROS_PARA_BUZZ = "/NumerosParaBuzz.csv";
    private final Exercise1Week3 exercise1Week3 = new Exercise1Week3();

    @ParameterizedTest
    @CsvFileSource(resources = NUMEROS_PARA_FIZZBUZZ)
    void casoFizzBuzz(Integer numero)
    {
        Assertions.assertEquals(exercise1Week3.FIZZBUZZ ,exercise1Week3.fizzbuzz(numero));
    }

    @ParameterizedTest
    @CsvFileSource(resources = NUMEROS_PARA_FIZZ)
    void casoFizz(Integer numero)
    {
        Assertions.assertEquals(exercise1Week3.FIZZ,exercise1Week3.fizzbuzz(numero));
    }
    @ParameterizedTest
    @CsvFileSource(resources = NUMEROS_PARA_BUZZ)
    void casoBuzz(Integer numero)
    {
        Assertions.assertEquals(exercise1Week3.BUZZ,exercise1Week3.fizzbuzz(numero));
    }

    @Test
    void casoNoEsFizzBizz()
    {
        assertEquals("77",exercise1Week3.fizzbuzz(77));
    }
    @Test
    void casoNumeroNegativo()
    {
        assertEquals("-89", exercise1Week3.fizzbuzz(-89));
    }
    @Test
    void casoNumeroNegativoFizzBuzz()
    {
        assertEquals(exercise1Week3.FIZZBUZZ, exercise1Week3.fizzbuzz(-15));
    }
    @Test
    void casoNull()
    {
        assertThrows(NullPointerException.class, () -> exercise1Week3.fizzbuzz(null));
    }
}