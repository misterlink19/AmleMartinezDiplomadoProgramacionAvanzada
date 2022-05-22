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
    private IceScream creaHelado(String name, String flavor, BigDecimal amount) {
        return IceScream.builder().name(name).flavor(flavor).amount(amount).build();
        }

    @Test
    void probandoFuncionalidadDeLaMaquinaDeHelados()
    {
        List<IceScream> losHelados = new ArrayList<>();

        losHelados.add(creaHelado("Helado de", "Fresa",new BigDecimal(100)));
        losHelados.add(creaHelado("Helado de", "chocolate",new BigDecimal(150)));
        losHelados.add(creaHelado("Helado de", "chicle",new BigDecimal(50)));


    }
}