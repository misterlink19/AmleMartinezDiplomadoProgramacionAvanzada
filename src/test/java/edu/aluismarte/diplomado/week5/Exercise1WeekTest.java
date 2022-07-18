package edu.aluismarte.diplomado.week5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Usar el API para
 *
 * @author aluis on 5/8/2022.
 */
public class Exercise1WeekTest {

    private final Exercise1Week5 exercise1Week5 = new Exercise1Week5();

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
    void noExistCodeTest() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/cats/Cat-404.jpg");
        assertNotNull(inputStream);
        BufferedImage noFoundCat = ImageIO.read(inputStream);
        BufferedImage noExist = exercise1Week5.getCatUsingStatusCode(-1);
        assertNotNull(noExist);
        String expected = Base64.getEncoder().encodeToString(toByteArray(noFoundCat, "jpg"));
        String actual = Base64.getEncoder().encodeToString(toByteArray(noExist, "jpg"));
        assertEquals(expected, actual);
    }

    @Test
    void normalCodeTest() {
        for (Integer code : List.of(200, 201, 202, 203, 300, 400, 500)) {
            BufferedImage noExist = exercise1Week5.getCatUsingStatusCode(code);
            assertNotNull(noExist);
        }
    }

    @Nested
    class HTTTPCodeTest {

        @Test
        void cat200Test() throws IOException {
            InputStream inputStream = getClass().getResourceAsStream("/cats/Cat-200.jpg");
            assertNotNull(inputStream);
            BufferedImage expectedImage = ImageIO.read(inputStream);
            BufferedImage actualImage = exercise1Week5.getCatUsingStatusCode(200);
            assertNotNull(actualImage);
            String expected = Base64.getEncoder().encodeToString(toByteArray(expectedImage, "jpg"));
            String actual = Base64.getEncoder().encodeToString(toByteArray(actualImage, "jpg"));
            assertEquals(expected, actual);
        }

        @Test
        void cat400Test() throws IOException {
            InputStream inputStream = getClass().getResourceAsStream("/cats/Cat-400.jpg");
            assertNotNull(inputStream);
            BufferedImage expectedImage = ImageIO.read(inputStream);
            BufferedImage actualImage = exercise1Week5.getCatUsingStatusCode(400);
            assertNotNull(actualImage);
            String expected = Base64.getEncoder().encodeToString(toByteArray(expectedImage, "jpg"));
            String actual = Base64.getEncoder().encodeToString(toByteArray(actualImage, "jpg"));
            assertEquals(expected, actual);
        }

        @Test
        void cat500Test() throws IOException {
            InputStream inputStream = getClass().getResourceAsStream("/cats/Cat-500.jpg");
            assertNotNull(inputStream);
            BufferedImage expectedImage = ImageIO.read(inputStream);
            BufferedImage actualImage = exercise1Week5.getCatUsingStatusCode(500);
            assertNotNull(actualImage);
            String expected = Base64.getEncoder().encodeToString(toByteArray(expectedImage, "jpg"));
            String actual = Base64.getEncoder().encodeToString(toByteArray(actualImage, "jpg"));
            assertEquals(expected, actual);
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
