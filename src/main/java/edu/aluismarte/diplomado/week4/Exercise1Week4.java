package edu.aluismarte.diplomado.week4;

import edu.aluismarte.diplomado.model.week4.IceScream;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Ice Scream maker
 * <p>
 * El objetivo es transformar esta función en la forma menos acoplada, pues tiene 2 lógicas juntas
 * - El cálculo del precio
 * - La mezcla de los sabores
 * - La construcción del nombre del nuevo helado
 *
 * @author aluis on 5/8/2022.
 */
public class Exercise1Week4 {

    /**
     * Cuando se combinan los helados, se toma el precio del helado más costoso y se usa como base
     * Una vez tienes el precio base, se le adiciona por cada sabor el porcentaje de combinaciones
     * <p>
     * Si tengo los siguientes helados el resultado es el siguiente:
     * <p>
     * Fresa 100 pesos, chocolate 150 pesos, chicle 50 y el porcentaje de combinación es 60%
     * <p>
     * Precio base 150 pesos, y sumo el 60% de 100 que serian 60 y el 60% 50 del helado de chicle
     * Resultado = 150 + 60 + 30 = 240 vale el nuevo helado
     * <p>
     * El nombre del helado se genera usando los sabores de los otros helados
     * Ejemplo, name = Helado de Chocolate, Fresa y Chicle (el helado de menor valor va al final)
     * <p>
     * El sabor del helado será mixto.
     *
     * @param iceScreams                Helados a combinar
     * @param percentageCombinationCost Porcentaje a usar como incremento según el costo de cada helado
     * @return El nuevo helado basado en el nombre del conjunto
     */
    public IceScream createIceScreamCombination(List<IceScream> iceScreams, Double percentageCombinationCost) {
        IceScream elHeladoResultante = new IceScream();
        if (percentageCombinationCost == null) {
            return IceScream.builder().build();
        }
        if (iceScreams.isEmpty()) {
            return IceScream.builder().build();
        }
        return IceScream.builder()
                .id("MiID")
                .name(mezcladoraDeHelados(iceScreams))
                .flavor("MIXTO")
                .amount(calculadoraDePreciosDeHelados(iceScreams, percentageCombinationCost))
                .build();
    }

//    El cálculo del precio
    private BigDecimal calculadoraDePreciosDeHelados(List<IceScream> helados, double porcentajeDeCombo)
    {
        helados = organizaHelados(helados);
        BigDecimal resultado = new BigDecimal(-1);
        IceScream heladoTemporal = new IceScream();
        for (IceScream heladito: helados) {
            if(resultado.doubleValue() == -1) {
               resultado = heladito.getAmount();
            }else {
                BigDecimal porcentajeCalculado =  new BigDecimal(porcentajeDeCombo).divide(new BigDecimal(100), 2, RoundingMode.CEILING);
                resultado = resultado.add(heladito.getAmount().multiply(porcentajeCalculado));
            }
        }
        return resultado;
    }
// * - La mezcla de los sabores
    @NotNull
    private String mezcladoraDeHelados(List<IceScream> helados)
    {
        StringBuilder construyeNombre = new StringBuilder("Helado de ");
        helados = organizaHelados(helados);

        for (int i = 0; i < helados.size(); i++) {
            IceScream heladoTemporal = helados.get(i);
            construyeNombre.append(heladoTemporal.getName());
            if( i == helados.size() - 2) {
                construyeNombre.append(" y ");
            }else if( i < helados.size() - 1) {
                construyeNombre.append(", ");
            }
        }
        return construyeNombre.toString();
    }

    // * - Organizando los helados.
    private List<IceScream> organizaHelados(@NotNull List<IceScream> helados)
    {
        helados.sort((o1, o2) -> Double.compare(o2.getAmount().doubleValue(), o1.getAmount().doubleValue()));
        return helados;
    }
}
