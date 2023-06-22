package techproed.day17_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementsReferanceException extends TestBase {

    @Test
    public void test01() {
        //techproeducation sayfasina gidiniz
        driver.get("https://techproeducation.com");
        wait(1);

        //reklami kapatin
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        wait(1);

        //sayfayi yenileyelim
        driver.navigate().refresh();
        wait(1);

        //LMS login butonuna tiklayin
        driver.findElement(By.xpath("(//*[@class='elementor-item'])[4]")).click();

    }

    @Test
    public void test02() {
        //techproeducation sayfasina gidiniz
        driver.get("https://techproeducation.com");
        wait(1);

        //reklami kapatin
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
       // wait(1);

        //LMS login butonunun locat'ini alalim
        WebElement lmsLogin = driver.findElement(By.xpath("(//*[@class='elementor-item'])[4]"));

        //sayfayi yenileyelim
        driver.navigate().refresh();
       // wait(1);

        //LMS login butonuna tiklayin
        lmsLogin.click(); //bayatlamis bir webElement kullanmis oldugumu icin hata vericek
        /*
        lmsLogin webElement'ini locate ettikten sonra sayfayi yeniledigimiz icin LMS LOGIN webElement'i
        eskidi, bayatladi. Sonrasinda bayatlayan webElement'i clik yaptigimiz icin StaleElementReferenceException hatasi aldik.
        Bu exception'i handle edebilmek icin refreh yaptiktak sonra tekrar ayni locat'i webElement'e atamamiz gerekiyor.
         */

    }

    @Test
    public void test03() {

        //techproeducation sayfasina gidiniz
        driver.get("https://techproeducation.com");
        wait(1);

        //reklami kapatin
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        // wait(1);

        //LMS login butonunun locat'ini alalim
        WebElement lmsLogin = driver.findElement(By.xpath("(//*[@class='elementor-item'])[4]"));

        //sayfayi yenileyelim
        driver.navigate().refresh();
        // wait(1);

        //LMS login butonuna tiklayin
        //lmsLogin.click(); //bayatlamis bir webElement kullanmis oldugumu icin hata vericek
        driver.findElement(By.xpath("(//*[@class='elementor-item'])[4]")).click();
    }
}
