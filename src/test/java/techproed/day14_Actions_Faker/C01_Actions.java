package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {


    @Test
    public void test01() {
        driver.get("https://techproeducation.com ");
        wait(1);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
      //  action.sendKeys(Keys.END).perform();

        wait(2);

        action.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP)
                .sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).perform();

    }

    @Test
    public void test02() {
        driver.get("https://techproeducation.com ");
        wait(1);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        Actions action = new Actions(driver);
       // action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN)
       //         .sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
          action.sendKeys(Keys.END);

        wait(2);

       // action.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP)
       //         .sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).perform();

        action.sendKeys(Keys.HOME).build().perform();
        //build methodu action'lari birlestirmek icin kullanilan methoddur.
        //release() methodu ise mause'u birakir.
    }

    @Test
    public void test03() {
        driver.get("https://techproeducation.com ");
        wait(1);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        Actions action = new Actions(driver);
        action.scrollByAmount(0,1500).perform();

        wait(2);
        action.scrollByAmount(0,-1500).perform();


    }
}
