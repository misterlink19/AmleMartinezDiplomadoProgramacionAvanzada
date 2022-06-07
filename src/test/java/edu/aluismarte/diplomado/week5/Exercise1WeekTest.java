package edu.aluismarte.diplomado.week5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Usar el API para
 *
 * @author aluis on 5/8/2022.
 */
public class Exercise1WeekTest {

    private final Exercise1Week5 exercise1Week5 = new Exercise1Week5();
    private static final String codigosDeGatos = "/codigoParaGatos.csv";

    private File catImageFile;
    private int count = 0;

    @BeforeEach
    void beforeEachTest() {
        catImageFile = new File("cat" + count + ".jpg");
        count++;
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("Eliminando archivos");
        for (int i = 0; i < count; i++) {
            File cat = new File("cat" + i + ".jpg");
            if (cat.exists()) {
                if (cat.delete()) {
                    System.out.println("Foto eliminada " + cat.getName());
                } else {
                    System.out.println("No se pudo eliminar la foto " + cat.getName());
                }
            }
        }
    }
    @Test
    void casoNoExisteCodigo() throws IOException {
        InputStream datosEntrada = getClass().getResourceAsStream("/cats/Cat-404.jpg");
        assertNotNull(datosEntrada);
        BufferedImage gatoNoEncontrado = ImageIO.read(datosEntrada);
        BufferedImage noExiste = exercise1Week5.getCatUsingStatusCode(-1);
        assertNotNull(noExiste);
        String esperado = Base64.getEncoder().encodeToString(toByteArray(gatoNoEncontrado, "jpg"));
        String actual = Base64.getEncoder().encodeToString(toByteArray(noExiste, "jpg"));
        assertEquals(esperado,actual);
    }
    @ParameterizedTest
    @CsvFileSource(resources = codigosDeGatos)
    void casoFuncionamientoDeLaAPI(Integer codigo)
    {
        BufferedImage gatoEncontrado = exercise1Week5.getCatUsingStatusCode(codigo);
        assertNotNull(gatoEncontrado);
    }

    @Nested
    class HTTTPCodeTest {
        @Test
        void casoGato200() throws IOException {

            InputStream datosEntrada = getClass().getResourceAsStream("/cats/Cat-200.jpg");
                    assertNotNull(datosEntrada);
                    BufferedImage gatoLocal = ImageIO.read(datosEntrada);
                    BufferedImage gatoDeAfuera = exercise1Week5.getCatUsingStatusCode(200);
                    assertNotNull(gatoDeAfuera);
                    String esperado = Base64.getEncoder().encodeToString(toByteArray(gatoLocal, "jpg"));
                    String actual = Base64.getEncoder().encodeToString(toByteArray(gatoDeAfuera, "jpg"));
                    assertEquals(esperado,actual);
        }

        @Test
        void casoGato400() throws IOException {
            InputStream datosEntrada = getClass().getResourceAsStream("/cats/Cat-400.jpg");
            assertNotNull(datosEntrada);
            BufferedImage gatoLocal = ImageIO.read(datosEntrada);
            BufferedImage gatoDeAfuera = exercise1Week5.getCatUsingStatusCode(400);
            assertNotNull(gatoDeAfuera);
            String esperado = Base64.getEncoder().encodeToString(toByteArray(gatoLocal, "jpg"));
            String actual = Base64.getEncoder().encodeToString(toByteArray(gatoDeAfuera, "jpg"));
            assertEquals(esperado,actual);
        }

        @Test
        void casoGato500() throws IOException {
            InputStream datosEntrada = getClass().getResourceAsStream("/cats/Cat-500.jpg");
            assertNotNull(datosEntrada);
            BufferedImage gatoLocal = ImageIO.read(datosEntrada);
            BufferedImage gatoDeAfuera = exercise1Week5.getCatUsingStatusCode(500);
            assertNotNull(gatoDeAfuera);
            String esperado = Base64.getEncoder().encodeToString(toByteArray(gatoLocal, "jpg"));
            String actual = Base64.getEncoder().encodeToString(toByteArray(gatoDeAfuera, "jpg"));
            assertEquals(esperado,actual);
        }
    }
    private void saveImage(BufferedImage bufferedImage) throws IOException {
        ImageIO.write(bufferedImage, "jpg", catImageFile);
    }

    public static byte[] toByteArray(BufferedImage bufferedImage, String format) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, format, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();

    }
}
