package edu.aluismarte.diplomado.week4;

import edu.aluismarte.diplomado.model.week4.Operation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

/**
 * Escribir los test del código
 *
 * @author aluis on 5/1/2022.
 */
public class HomeworkTest {

    private final Homework homework = new Homework();


    @Test
    void probandoSuma() throws Exception {
        Assertions.assertEquals(homework.calculateAndSave(Operation.SUM,1,9,new FileWriter("C:/Cosa/archivo.txt")), 10);
    }
    @Test
    void probandoMultiplicacion() throws Exception {
        Assertions.assertEquals(homework.calculateAndSave(Operation.MULT,2,3,new FileWriter("C:/Cosa/archivo.txt")), 6);
    }
    @Test
    void probandoDivision() throws Exception {
        Assertions.assertEquals(homework.calculateAndSave(Operation.DIV,12,3,new FileWriter("C:/Cosa/archivo.txt")), 4);
    }
    @Test
    void probandoCuandoOperacionEsNull() throws Exception {
        Assertions.assertNull(homework.calculateAndSave(null,1,9,new FileWriter("C:/Cosa/archivo.txt")));
    }
    @Test
    void probandoSiEscribeBienArchivo() throws Exception {
        Assertions.assertEquals(homework.calculateAndSave(Operation.SUM,1,9,new FileWriter("C:/Cosa/archivo.txt")), 10);
        Assertions.assertEquals(homework.calculateAndSave(Operation.MULT,2,3,new FileWriter("C:/Cosa/archivo.txt")), 6);
        Assertions.assertEquals(homework.calculateAndSave(Operation.DIV,12,3,new FileWriter("C:/Cosa/archivo.txt")), 4);
//        Assertions.assertNull(homework.calculateAndSave(null,1,9,new FileWriter("C:/Cosa/archivo.txt")));

    }





}
