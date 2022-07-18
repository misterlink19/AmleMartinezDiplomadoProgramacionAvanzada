package edu.aluismarte.diplomado.week3;

/**
 * @author aluis on 5/8/2022.
 */
public class Exercise1Week3 {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZBUZZ = FIZZ + BUZZ;

    /**
     * Un número es Fizz cuando es divisible entre 5
     * Un número es Buzz cuando es divisible entre 3
     * Un número es FizzBuzz cuando es divisible entre 3 y 5 al mismo tiempo
     * Si no cumple con ninguna condición anterior se retorna el número
     *
     * @param number número a comprobar para saber si es Fizz, Buzz o FizzBuzz
     * @return Un string que es igual a Fizz, Buzz o FizzBuzz
     */
    public String fizzbuzz(Integer number) {
        if (number == null) {
            throw new NullPointerException("Null cant be null");
        }
        return solution1(number);
//        return solution2(number);
//        return solution3(number);
    }

    private String solution1(Integer number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return FIZZBUZZ;
        }
        if (number % 3 == 0) {
            return BUZZ;
        }
        if (number % 5 == 0) {
            return FIZZ;
        }
        return number + "";
    }

    private String solution2(Integer number) {
        if (number % 15 == 0) { // Mínimo común múltiplo de 3 y 5 es 15
            return FIZZBUZZ;
        }
        if (number % 3 == 0) {
            return BUZZ;
        }
        if (number % 5 == 0) {
            return FIZZ;
        }
        return number + "";
    }

    private String solution3(Integer number) {
        StringBuilder stringBuilder = new StringBuilder();
        if (number % 5 == 0) {
            stringBuilder.append(FIZZ);
        }
        if (number % 3 == 0) {
            stringBuilder.append(BUZZ);
        }
        if (stringBuilder.isEmpty()) {
            stringBuilder.append(number);
        }
        return stringBuilder.toString();
    }
}
