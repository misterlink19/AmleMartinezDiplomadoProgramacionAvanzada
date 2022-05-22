package edu.aluismarte.diplomado.week4;

import edu.aluismarte.diplomado.model.week4.Operation;

import java.io.File;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * Reescribir este código en piezas testeables y hacer los test cubriendo multiples escenarios
 * <p>
 * En vez de escribir directo a disco el archivo debería recibir donde escribirlo (el file directamente)
 * El cálculo no debe ser en la function, es una lógica separada
 *
 * @author aluis on 4/3/2022.
 * @implSpec La función existente debe quedarse ahi, pues la nueva se presume tendrá más parámetros
 */
public class Homework {

    // TODO crear una funcion nueva sin borrar la vieja

    public static void calculateAndSave(Operation operation, int a, int b) throws Exception {
        Double result = switch (operation) {
            case SUM -> (double) (a + b);
            case MULT -> (double) a * b;
            case DIV -> (double) a / b;
            default -> null;
        };
        if (result == null) {
            throw new Exception("No operation");
        }
        File file = new File("filename.txt");
        try (PrintWriter out = new PrintWriter(file)) {
            out.println("Result is: " + result);
        }
    }

    public double calculateAndSave(Operation operation, int a, int b, Writer archivo) throws Exception {

        Double result = switch (operation) {
            case SUM -> (double) (a + b);
            case MULT -> (double) a * b;
            case DIV -> (double) a / b;
            default -> null;
        };

        if (result == null) {
            return Double.parseDouble(null);
        }

        try (PrintWriter out = new PrintWriter(archivo)) {
            out.println("Result is: " + result);
        }

        return result;
    }
}
