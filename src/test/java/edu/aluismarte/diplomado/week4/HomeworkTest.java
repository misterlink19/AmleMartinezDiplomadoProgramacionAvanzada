package edu.aluismarte.diplomado.week4;

import edu.aluismarte.diplomado.model.week4.Operation;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Escribir los test del código
 *
 * @author aluis on 5/1/2022.
 */
public class HomeworkTest {

    private static final File archivo = new File("pruebaOperaciones.txt");
    private final Homework homework = new Homework();

    @AfterAll
    static void afterAllTest() {
        assertTrue(archivo.delete());
    }

    @Test
    void casoOperationNull() {
        assertThrows(Homework.OperationNullException.class, () -> {
            Operation operacion = null;
            Double a = null;
            Double b = null;
            File archivo = null;
            Homework.calculateAndSave(operacion, a, b, archivo);
        });
    }

    @Test
    void fileNullTest() {
        assertThrows( NullPointerException.class, () -> {
            Double a = null;
            Double b = null;
            File archivo = null;
            Homework.calculateAndSave(Operation.SUM, a, b, archivo);
        });
    }

    @Test
    void casoEscribiendoEnArchivo() throws Exception {
        homework.calculateAndSave(Operation.SUM, 2.0, 2.0, archivo);
        assertTrue(archivo.exists());
        byte[] bytes = Files.readAllBytes(archivo.toPath());
        String datos = new String(bytes);
        assertEquals("Result is: 4.0", datos);
    }

    @Test
    void casoSuma() throws Exception {
        homework.calculateAndSave(Operation.SUM, 2.0, 2.0, archivo);
        byte[] bytes = Files.readAllBytes(archivo.toPath());
        String datos = new String(bytes);
        assertEquals("Result is: 4.0", datos);
    }
    @Test
    void casoMultiplicacion() throws Exception {
        homework.calculateAndSave(Operation.MULT, 4.0, 4.0, archivo);
        byte[] bytes = Files.readAllBytes(archivo.toPath());
        String datos = new String(bytes);
        assertEquals("Result is: 16.0", datos);
    }
    @Test
    void casoDivision() throws Exception {
        homework.calculateAndSave(Operation.DIV, 20.0, 5.0, archivo);
        byte[] bytes = Files.readAllBytes(archivo.toPath());
        String datos = new String(bytes);
        assertEquals("Result is: 4.0", datos);
    }

}
