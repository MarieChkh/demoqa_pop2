package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZipFileParsingTest {

    private final ClassLoader cl = ZipFileParsingTest.class.getClassLoader();

    @Test
    void zipParsingTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("files.zip")
        )) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                System.out.println(entry.getName());
            }
        }
    }

    @Test
    void pdfFileFromZipFileParsingTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                Objects.requireNonNull(cl.getResourceAsStream("files.zip"))
        )) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".pdf")) {
                    PDF pdf = new PDF(zis);
                    assertTrue(pdf.text.contains("Что чувствуют матери, отправляя сыновей на фронт?"));
                    assertTrue(pdf.text.contains("Советский писатель убежден в том"));
                    assertTrue(pdf.text.contains("Таким образом"));
                }
            }
        }
    }

    @Test
    void xlsxFileFromZipFileParsingTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                Objects.requireNonNull(cl.getResourceAsStream("files.zip"))
        )) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".xlsx")) {
                    XLS xls = new XLS(zis);
                    assertEquals("Петров", xls.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue());
                    assertEquals("Street 33", xls.excel.getSheetAt(0).getRow(2).getCell(4).getStringCellValue());
                }
            }
        }
    }

    @Test
    void csvFileFromZipFileParsingTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                Objects.requireNonNull(cl.getResourceAsStream("files.zip"))
        )) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".csv")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis));

                    List<String[]> data = csvReader.readAll();
                    Assertions.assertEquals(3, data.size());
                    Assertions.assertArrayEquals(
                            new String[] {"Alex","Egorov"},
                            data.get(0)
                    );
                    Assertions.assertArrayEquals(
                            new String[] {"Ekaterin","Ivanova"},
                            data.get(1)
                    );
                    Assertions.assertArrayEquals(
                            new String[] {"John","Snow"},
                            data.get(2)
                    );
                }
            }
        }
    }
}
