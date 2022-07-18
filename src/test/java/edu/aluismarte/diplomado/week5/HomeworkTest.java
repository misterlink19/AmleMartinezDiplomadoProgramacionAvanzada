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
    void noReplaceTest() {
        String template = "${hola}";
        Homework.VarsReplace varsReplace = Homework.VarsReplace.builder().varReplace("").value("").build();
        String result = homework.prepareTemplate(List.of(varsReplace), template);
        assertEquals(template, result);
        System.out.println(result);
    }

    @Test
    void replace1varTest() {
        Homework.VarsReplace varsReplace = Homework.VarsReplace.builder().varReplace("hola").value("mundo").build();
        String result = homework.prepareTemplate(List.of(varsReplace), "${hola}");
        assertEquals("mundo", result);
        System.out.println(result);
    }
}