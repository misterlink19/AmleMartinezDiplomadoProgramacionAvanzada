package edu.aluismarte.diplomado.week1;

import java.util.ArrayList;
import java.util.List;

public class DemoDeSuma {
 /*
    Parejas que suman igual
    Escribir un método que returne la lista de parejas que sumados (cada numero separado por una coma en un string) sea igual a el resultado esperado

    Ejemplo:
    resultado = 5
    numeros=[1,4,5,0]

            1,4
            5,0
*/

    public static List<String> pairOfSumToTarget(List<Integer> numbers, int target) {
        List<String> resultant = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i ; j < numbers.size() ; j++) {
                if((numbers.get(i) + numbers.get(j) ) == target)
                {
                    resultant.add(numbers.get(i) + "," + numbers.get(j));
                }
            }
        }
        return resultant;
    }

    public static void main(String[] args) {
        List<String> resultados = pairOfSumToTarget(List.of(1, 4, 2, 3, 5, 0),5);

        for (String resultado : resultados) {
            System.out.println(resultado);
        }
    }
}

