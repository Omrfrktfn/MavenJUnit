package techproed.day21_Excel_JsExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExcutorClick extends TestBase {

    /*
         Bir webSayfasinda bazi elementler olusturulurken javascript kodlariyla olusturulmus olabilir.
    Bu webelementleri handle edebilmek icin javascriptiExecutor arayuzunu kullanmamiz gerekir.
    Bir webElement Javascript kodlari ile yazilmamis olsada , javascriptExecutor ile o webElement'i handle edebiliriz.
    Normal bildigimiz methodlardan daha yavas calisacagi icin bildigimiz methodlar isimizi goruyorsa onlari kullaniriz.

   <script> tagi ile olusturulmsu olan webelementlere de js excutor ile handle edebiliriz.
     */

    @Test
    public void test01() {
        //amazon sayfasina gidiniz.
        driver.get("https://amazon.com");
        wait(2);

        //sell linkiin resmini alalim

        driver.findElement(By.xpath("//*[@class='a-button a-spacing-top-base a-button-base glow-toaster-button glow-toaster-button-dismiss']")).click();

        wait(1);

        WebElement sellLink = driver.findElement(By.xpath("//*[text()='Sell']"));
        webElementScreenshot(sellLink);

        //sell linkine js executor kullanarak tiklayiniz.

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", sellLink);
        wait(1);

        //basligin sell icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //syfanin resmini alalim
        takeScreenShot();
    }

    @Test
    public void test02() {
        //amazon sayfasina gidiniz.
        driver.get("https://amazon.com");
        wait(2);

        //sell linkiin resmini alalim
        WebElement sellLink = driver.findElement(By.xpath("//*[text()='Sell']"));
        webElementScreenshot(sellLink);

        //sell linkine js executor kullanarak tiklayiniz.

        driver.findElement(By.xpath("//*[@class='a-button a-spacing-top-base a-button-base glow-toaster-button glow-toaster-button-dismiss']")).click();

        wait(1);
        webElementScreenshot(sellLink);
        sellLink.click();

        /*
JS executor ile Webelementin önünde uyarı çıkmasına rağmen webelemente click yaptı çünkü kodlara direk ulaşıyor
Normal kullandığımız click methodu burda önünde farklı bir element olduğu için ElementClickInterceptedException:
hatası verdi.Dolayısıyla bu exception ile karşılaştığımızda da js executor ile bunu çözebiliriz
 */

        //basligin sell icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //syfanin resmini alalim
        takeScreenShot();

    }

    @Test
    public void test03() {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        wait(2);
        //sell linkinin resmini alalım
        driver.findElement(By.xpath("(//*[@class='a-button-inner'])[1]")).click();//-->uyarı kapatıldı

        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        wait(2);
        webElementScreenshot(sellLinki);

        //Sell linkine js executor kullanarak tıklayınız
        click(sellLinki);

        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanın resmini alalım
        takeScreenShot();


    }

    //Click Method
    public void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        }
    }
}
