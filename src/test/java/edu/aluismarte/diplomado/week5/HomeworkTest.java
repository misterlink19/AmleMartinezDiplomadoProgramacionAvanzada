package edu.aluismarte.diplomado.week5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author aluis on 5/8/2022.
 */
class HomeworkTest {

    private final Homework homework = new Homework();

    @Test
    void casoNoReemplazaNada()
    {
        String plantilla = "${Jamon con pollo}";
        Homework.VarsReplace aRemplazar = Homework.VarsReplace.builder().varReplace("").value("").build();
        String resultado = homework.prepareTemplate(List.of(aRemplazar),plantilla);
        assertEquals(plantilla, resultado);
    }
    @Test
    void casoReemplaza()
    {
        String plantilla = "${Jamon con pollo}";
        String mensajeIncial = "Jamon con pollo";
        String mensajeFinal = "Huevo con salami";
        Homework.VarsReplace aRemplazar = Homework.VarsReplace.builder().varReplace(mensajeIncial).value(mensajeFinal).build();
        String resultado = homework.prepareTemplate(List.of(aRemplazar),plantilla);
        assertEquals(mensajeFinal, resultado);
    }
}