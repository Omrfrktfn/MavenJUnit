package techproed.day21_Excel_JsExecutor;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_ExcellWrite {

    @Test
    public void test01() throws IOException {

        //Bir nufus sutunu olusturun
        String path = "src/test/java/resources/Capitals (1).xlsx";

        FileInputStream fis = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fis);

        //baskent nufuslarini excell dosyasina yaziniz.

        workbook.getSheet("Sheet1").getRow(0).createCell(2).setCellValue("NUFUS");
        workbook.getSheet("Sheet1").getRow(1).createCell(2).setCellValue("10000");
        workbook.getSheet("Sheet1").getRow(2).createCell(2).setCellValue("11000");
        workbook.getSheet("Sheet1").getRow(3).createCell(2).setCellValue("12000");
        workbook.getSheet("Sheet1").getRow(4).createCell(2).setCellValue("13000");
        workbook.getSheet("Sheet1").getRow(5).createCell(2).setCellValue("14000");

        //excell'de bir hucre olusturmak icin createCell methodu kullanilir.
        //Hucre icine yazdiracagimiz deger icin setCellValue methdou kullanilir.

        FileOutputStream fos = new FileOutputStream(path);
        //datalari bizim class'imizdan capitals dosyasina gondericegiz.

        workbook.write(fos);
        //workbook'taki datalari fos'a yazdirdik.



    }
}
