package edu.aluismarte.diplomado.week4;

import edu.aluismarte.diplomado.model.week4.IceScream;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author aluis on 5/9/2022.
 */
class Exercise1Week4Test {

    private final Exercise1Week4 exercise1Week4 = new Exercise1Week4();

    @Test
    void initialCaseTest() {
        List<IceScream> iceScreams = new ArrayList<>();
        iceScreams.add(IceScream.builder().name("Fresa").amount(new BigDecimal(100)).build());
        iceScreams.add(IceScream.builder().name("Chocolate").amount(new BigDecimal(150)).build());
        iceScreams.add(IceScream.builder().name("Chicle").amount(new BigDecimal(50)).build());

        IceScream iceScreamCombination = exercise1Week4.createIceScreamCombination(iceScreams, 60d);
        assertNotNull(iceScreamCombination);
        System.out.println(iceScreamCombination);
        assertEquals("Helado de Chocolate, Fresa y Chicle", iceScreamCombination.getName());
        assertEquals("MIXTO", iceScreamCombination.getFlavor());
        assertEquals(new BigDecimal("240.00"), iceScreamCombination.getAmount());
    }

}