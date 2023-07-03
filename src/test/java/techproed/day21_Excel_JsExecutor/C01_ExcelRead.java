package techproed.day21_Excel_JsExecutor;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead extends TestBase {

    @Test
    public void test01() throws IOException {


        //3. satir 1. sutun degerini yazdirin ve "France" oldugunu test edin.

        //1-dosya yolunu aliriz = src/test/java/resources/Capitals (2).xlsx
        String path = "src/test/java/resources/Capitals (1).xlsx";

        //2- olusturulan doyayi sisteme getirme islemi yapilir.
        FileInputStream fis = new FileInputStream(path);

        //3- dosyayi workbook'a atamaliyiz. java ortaminda bir excel dosyasi olusturmaliyiz.
        Workbook workbook = WorkbookFactory.create(fis);

        //4-sayfayi (sheet) secmeliyiz.
        Sheet sheet = workbook.getSheet("Sheet1");

        //5- satiri (row) secmeliyiz.
        Row row = sheet.getRow(3); // birinci satir index 0'dan baslar

        //hucreyi(cell) secmeliyi.z
        Cell cell = row.getCell(1);

        String satir3Sutun1 = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println(satir3Sutun1);

        Assert.assertEquals("France", satir3Sutun1);


        //son satir sayisini bulunuz.
        int sonSatirSayisi = workbook.getSheet("Sheet1").getLastRowNum();
        System.out.println("Son Satir Sayisi : " + sonSatirSayisi);

        //kullanilan satir sayisini bulunuz.
        int kullanilanSatirSayisi = workbook.getSheet("Sheet1").getPhysicalNumberOfRows();
        System.out.println("Kullanilan Satir Sayisi : " + kullanilanSatirSayisi);

        //excell tablosundaki kullanilan satir sayisini getPhysicalNumberOfRows methodu ile alabiliriz.
        //(index olarak vermez.)

    }


    @Test
    public void test02() throws IOException {

        //Capital dosyasindaki tum verileri yazdirirniz

        Map<String, String> capitalsMap = new HashMap<>();
        //Capitals dosyasındaki tüm verileri koyabilecegimiz en uygun java objesi map'dir.

        String dosyaYolu =  "src/test/java/resources/Capitals (1).xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatirSayisi = workbook.getSheet("Sheet1").getLastRowNum();

        for (int i = 0; i <= sonSatirSayisi; i++) {
            String key = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String value = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();

            capitalsMap.put(key, value);

         //   System.out.println(key+"/"+value);

        }
        System.out.println(capitalsMap);

    }
}
