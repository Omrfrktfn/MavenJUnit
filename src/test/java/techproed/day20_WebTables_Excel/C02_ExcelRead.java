package techproed.day20_WebTables_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ExcelRead extends TestBase {

    @Test
    public void test01() throws IOException {

        //excel dosyasindan veri okuyabilmemiz icin
        //1-dosya yolunu aliriz = src/test/java/resources/Capitals (2).xlsx
        String dosyaYolu = "src/test/java/resources/Capitals (2).xlsx";

        //2- olusturulan doyayi sisteme getirme islemi yapilir.
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //3- dosyayi workbook'a atamaliyiz. java ortaminda bir excel dosyasi olusturumaliyi
        Workbook workbook = WorkbookFactory.create(fis);

        //4-sayfayi (sheet) secmeliyiz.
        Sheet sheet = workbook.getSheet("Sheet1");

        //5- satiri (row) secmeliyiz.
        Row row = sheet.getRow(0); // birinci satir index 0'dan baslar

        //hucreyi(cell) secmeliyi.z
        Cell cell = row.getCell(0);

    }

    @Test
    public void test02() throws IOException {

        //Kisa Yontem

        //1.satir 1.sutundaki bilgiyi yazdiriniz.
        String dosyaYolu = "src/test/java/resources/Capitals (2).xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);


        Workbook workbook = WorkbookFactory.create(fis);

        String satir1Sutun1 = workbook.getSheet("Sheet1").getRow(0).getCell(0).toString();

        System.out.println(satir1Sutun1);

    }

}

