package techproed.day18_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_ScreenShot extends TestBase {

    @Test
    public void test01() {

        //Techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");
        wait(1);

        //Cikan reklami kapatalim
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        wait(1);

        //sayfanın resmini alalım
        takeScreenShot();
        wait(1);

        //Arama bölümünde java aratalım
        driver.findElement(By.id("elementor-search-form-9f26725")).sendKeys("java", Keys.ENTER);

        //ve sonuc yazısının resmini alalım
        WebElement resultWrite = driver.findElement(By.xpath("(//*[@class='elementor-heading-title elementor-size-default'])[1]"));
        webElementScreenshot(resultWrite);

        //Yeni bir sekmede amazona gidelim

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        wait(1);

        //sayfanın resmini alalım
        takeScreenShot();
        wait(1);

        //arama bölümde iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        wait(1);

        //ve sonuc yazısının resmini alalım
        WebElement resultWrite1 = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        webElementScreenshot(resultWrite1);
        wait(1);

        //tekrar tecpro sayfasına geçelim ve sayfa resmini alalım
        switchToWindow2(0);
        takeScreenShot();
    }
}
