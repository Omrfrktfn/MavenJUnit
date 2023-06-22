package techproed.day17_Exception;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {

    @Test
    public void test01() {

        //techproeducation sayfasina gidiniz
        driver.get("https://techproeducation.com");
        wait(2);

        //reklami kapatin
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();


        //searchBox'a gorunur oluncaya kadar bekleyin
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement searchBox = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='elementor-search-form__input']")));

        //WebElement searchBox1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='elsdfasementor-search-form__input']")));
        //C02_TimeOutException.test01(C02_TimeOutException.java:30)\

    }

    @Test
    public void test02() {
        // https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        wait(1);

        // Start butonuna tıklayınız
        driver.findElement(By.xpath("//*[text()='Start']")).click();

        // Hello World! yazısının görünürlügünü test ediniz
        WebElement sonYazi = driver.findElement(By.xpath("//*[text()='Hello World!']"));
        WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait2.until(ExpectedConditions.visibilityOf(sonYazi));

        Assert.assertTrue(sonYazi.isDisplayed());
        //sayfa gec geldigi icn bu kisim _Exception.C02_TimeOutException.test02(C02_TimeOutException.java:47) hatasi veriyor.
    }
}
