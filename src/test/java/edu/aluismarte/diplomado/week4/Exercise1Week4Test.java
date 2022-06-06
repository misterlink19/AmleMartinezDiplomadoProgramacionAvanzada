package edu.aluismarte.diplomado.week4;

import edu.aluismarte.diplomado.model.week4.IceScream;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author aluis on 5/9/2022.
 */
class Exercise1Week4Test {

    private final Exercise1Week4 exercise1Week4 = new Exercise1Week4();

    @Test
    void casoInicial() {
        List<IceScream> helados = new ArrayList<>();
        helados.add(IceScream.builder().name("Chicle").amount(new BigDecimal(50)).build());
        helados.add(IceScream.builder().name("Fresa").amount(new BigDecimal(100)).build());
        helados.add(IceScream.builder().name("Chocolate").amount(new BigDecimal(150)).build());

        IceScream iceScreamCombination = exercise1Week4.createIceScreamCombination(helados, 60d);
        assertNotNull(iceScreamCombination);
        assertEquals("Helado de Chocolate, Fresa y Chicle", iceScreamCombination.getName());
        assertEquals("MIXTO", iceScreamCombination.getFlavor());
        assertEquals(new BigDecimal("240.00"), iceScreamCombination.getAmount());

    }

    @Test
    void casoHeladoNombreNull() {
        List<IceScream> helados = new ArrayList<>();
        IceScream iceScreamCombination = exercise1Week4.createIceScreamCombination(helados, 60d);
        assertNull(iceScreamCombination.getName());
    }

    @Test
    void casoHeladoFlavorNull() {
        List<IceScream> helados = new ArrayList<>();
        IceScream iceScreamCombination = exercise1Week4.createIceScreamCombination(helados, 60d);
        assertNull(iceScreamCombination.getFlavor());
    }

    @Test
    void casoHeladoAmountNull() {
        List<IceScream> helados = new ArrayList<>();
        IceScream iceScreamCombination = exercise1Week4.createIceScreamCombination(helados, 60d);
        assertNull(iceScreamCombination.getAmount());
    }

    @Test
    void casoComboNull() {
        List<IceScream> helados = new ArrayList<>();
        assertNull(exercise1Week4.createIceScreamCombination(helados, null).getId());
    }
}