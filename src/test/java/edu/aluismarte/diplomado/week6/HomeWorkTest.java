package edu.aluismarte.diplomado.week6;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author aluis on 5/2/2022.
 */
class HomeWorkTest {

    private final HomeWork homeWork = new HomeWork();
    private static final boolean CAMPO_REQUERIDO = true;
    private static final boolean CAMPO_NO_REQUERIDO = false;

    private static final boolean DATOS_POR_DEFECTO = true;
    private static final boolean SIN_DATOS_POR_DEFECTO = false;

    @TestFactory
    Stream<DynamicTest> casoTestDinámico() {
        Faker faker = new Faker();
        return IntStream.range(0, 30).mapToObj(value -> {
            String nombre = faker.name().fullName();
            return DynamicTest.dynamicTest("Nombre al azar de prueba: " + nombre, () -> {
                System.out.println("Usando el nombre: " + nombre);
                assertEquals(nombre, homeWork.formValidation(CAMPO_NO_REQUERIDO, SIN_DATOS_POR_DEFECTO, "", "",nombre));
                assertEquals(nombre, homeWork.formValidation(CAMPO_NO_REQUERIDO, DATOS_POR_DEFECTO, "", nombre,""));
                assertEquals(nombre, homeWork.formValidation(CAMPO_REQUERIDO, SIN_DATOS_POR_DEFECTO, nombre, "",""));
                assertEquals(nombre, homeWork.formValidation(CAMPO_REQUERIDO, DATOS_POR_DEFECTO, nombre, "",""));
            });
        });
    }

    
}