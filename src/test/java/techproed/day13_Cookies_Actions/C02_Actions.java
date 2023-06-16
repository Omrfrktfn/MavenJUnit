package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        wait(1);

        //Kutuya sag tıklayın
        WebElement kutu = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.contextClick(kutu).perform();
        wait(1);

        //Alert'te cikan yazinin"You selected a context menu"oldugunu test edin
        String actul = driver.switchTo().alert().getText();
        String excepted = "You selected a context menu";
        Assert.assertTrue(actul.equals(excepted));
        wait(1);

        //Tamam diyerek alert'i kapatın
        driver.switchTo().alert().accept();

    }
}
