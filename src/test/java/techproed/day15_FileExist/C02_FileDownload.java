package techproed.day15_FileExist;

import com.beust.ah.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownload extends TestBase {

    @Test
    public void test01() {
        //"https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        wait(2);

        File silinecekDosya = new File("C:\\Users\\Omer\\Downloads\\b10 all test cases, code.docx");
        silinecekDosya.delete();
        /*
        Eger localinizden otomasyon ile bir dosya silmek icin File class'indan obje olusturup daha sonrasinda
        dosya yolunu icine yerlestirdikten delete ile sileriz ve her calistirdigimizda eger daha oncesinde indirme
        islemi yapmis isek bir onceki silip yenisini indirme islemi yapar ve kopyalama isleminin onune gecmis oluruz.
         */

        //"b10 all test cases" dosyasını indirin
        WebElement indirilecekDosya = driver.findElement(By.xpath("//*[text()='b10 all test cases, code.docx']"));
        indirilecekDosya.click();
        wait(4);

        // Dosyanın başarıyla indirilip indirilmediğini test edin.

        //C:\Users\Omer\Downloads\b10 all test cases, code.docx
        String ortakKisim =System.getProperty("user.home");
        System.out.println(ortakKisim);
        String farkliKisim = "\\Downloads\\b10 all test cases, code.docx";
        System.out.println(farkliKisim);

        String dosyaYolu = ortakKisim+ farkliKisim;
        System.out.println(dosyaYolu);
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\Omer\\Downloads\\b10 all test cases, code.docx")));
    }
}
