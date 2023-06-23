package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot extends TestBase {

    @Test
    public void test01() throws IOException {

        //Techproeducation sayfasine gidelim
        driver.get("https://www.techproeducation.com");
        wait(1);

        //Cikan reklami kapatalim
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        wait(1);

        //Ve ekran goruntusunu alalim.
      //  String dosyaYolu = "src/test/java/techproed/ScreenShot";//kismini kenidmiz eklemeiyiz
        String dosyaYolu = "src/test/java/techproed/ScreenShot/screenShot.png";
        /*
        İlk olarak SS alacağımız da nereye kaydetmek istiyorsak oranın yolunu belirtelim.
        İkinci olarak TakesScreenShot arayüzünden obje oluşturuz
        ucuncu olarak FileUtils class'indan copyFile methodu ile ts objemizi kullanarak getScreenshot ile dosya
        yolunu belirtecegiz.
        */
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));

    }

    @Test
    public void test02() throws IOException{
        //Techproeducation sayfasine gidelim
        driver.get("https://www.techproeducation.com");
        wait(1);

        //Cikan reklami kapatalim
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        wait(1);

        //Ve ekran goruntusunu alalim.

        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("Screenshot/screenShot.png"));
        //kendi klasor olusturup onun icine aldi bu sekilde
    }

    @Test
    public void test03()throws IOException {
        //Amazon sayfasine gidelim
        driver.get("https://www.amazon.com");
        wait(1);

        //Ve ekran goruntusunu alalim.

        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date()); // tarihle ilgili yeni bir format
        /*
            SimpleDateFormat'i kullanarak yeni bir tarih formati olusturup bir String'e assing ederiz. Ve bunu dosya isminden once
            belirtiriz.
        */
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("Screenshot/screenShot"+ date +".png"));


    }

    @Test
    public void test04()throws IOException {
        //Techproeducation sayfasine gidelim
        driver.get("https://www.techproeducation.com");
        wait(1);

        //Cikan reklami kapatalim
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        wait(1);
        //Ve ekran goruntusunu alalim.

        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date()); // tarihle ilgili yeni bir format
        /*
            SimpleDateFormat'i kullanarak yeni bir tarih formati olusturup bir String'e assing ederiz. Ve bunu dosya isminden once
            belirtiriz.
        */
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("Screenshot/screenShot"+ date +".png"));
    }
}
