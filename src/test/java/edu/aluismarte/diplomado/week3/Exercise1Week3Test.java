package edu.aluismarte.diplomado.week3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author aluis on 5/8/2022.
 */
class Exercise1Week3Test {

    private final Exercise1Week3 exercise1Week3 = new Exercise1Week3();

    @Test
    void nullValueTest() {
        assertThrows(NullPointerException.class, () -> exercise1Week3.fizzbuzz(null));
    }

    @Test
    void divisibleBy3Case1Test() {
        assertEquals(Exercise1Week3.BUZZ, exercise1Week3.fizzbuzz(3));
    }

    @Test
    void divisibleBy5Case1Test() {
        assertEquals(Exercise1Week3.FIZZ, exercise1Week3.fizzbuzz(5));
    }

    @Test
    void divisibleBy5And3Case1Test() {
        assertEquals(Exercise1Week3.FIZZBUZZ, exercise1Week3.fizzbuzz(15));
    }

    @Test
    void noDivisorTest() {
        assertEquals("4", exercise1Week3.fizzbuzz(4));
    }

    @Test
    void useZeroTest() {
        assertEquals(Exercise1Week3.FIZZBUZZ, exercise1Week3.fizzbuzz(0));
    }

    @Test
    void negativeNumberTest() {
        assertEquals(Exercise1Week3.FIZZBUZZ, exercise1Week3.fizzbuzz(-15));
    }

    @Test
    void negativeNoDividerTest() {
        assertEquals("-4", exercise1Week3.fizzbuzz(-4));
    }

}