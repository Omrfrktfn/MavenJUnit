package techproed.day16_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExpilicitWait extends TestBase {

    @Test
    public void test01() {

        // https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        wait(1);

        // Start buttonuna tıkla
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        //wait(8); // bu islemi her defasinda ongoremedigimiz icin dinamik olmz

        // Hello World! Yazının sitede oldugunu test et
        WebElement element = driver.findElement(By.xpath("//*[text()='Hello World!']"));
        //Locate'ini aldığımız helloWorldText webelementini görünür olana kadar explicit wait ile bekleyeceğim
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait1.until(ExpectedConditions.visibilityOf(element));
        //visibilityOf methoduyla gorunur olana kadar bekler.

        Assert.assertEquals("Hello World!", element.getText());
    }

    @Test
    public void test02() {
        // https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        wait(1);

        // Start buttonuna tıkla
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        //wait(8); // bu islemi her defasinda ongoremedigimiz icin dinamik olmz

        // Hello World! Yazının sitede oldugunu test et
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));



        Assert.assertEquals("Hello World!", element.getText());

    }

    @Test
    public void test03() {
// https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        wait(1);

        // Start buttonuna tıkla
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        //wait(8); // bu islemi her defasinda ongoremedigimiz icin dinamik olmz

        // Hello World! Yazının sitede oldugunu test et
      new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));

        Assert.assertEquals("Hello World!", driver.findElement(By.xpath("(//h4)[2]")).getText());

    }

    @Test
    public void test04() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldText = driver.findElement(By.xpath("(//h4)[2]"));
        //Locate'ini aldığımız helloWorldText webelementini görünür olana kadar explicit wait ile bekleyeceğim
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));//-->max.20 saniye belirttik
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='loading']")));
        //invisibilityOfElementLocated() methodu ile loading webelementi kaybolana kadar bekler

        Assert.assertEquals("Hello World!",helloWorldText.getText());
    }
}
