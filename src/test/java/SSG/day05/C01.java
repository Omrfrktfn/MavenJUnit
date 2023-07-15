package SSG.day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01 extends TestBase {


    @Test
    public void assertionTesti() {
        driver.get("https://www.kitapyurdu.com/");

        String expectedUrl = "https://www.kitapyurdu.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

        String expectedTitle = "Kitapyurdu";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        WebElement logo = driver.findElement(By.cssSelector("[src='https://img.kitapyurdu.com/v1/getImage/fn:11682842/wh:dec2d77ad']"));
        Assert.assertTrue(logo.isDisplayed());

        WebElement aramaMotoru = driver.findElement(By.id("search-input"));
        aramaMotoru.sendKeys("java", Keys.ENTER);

        WebElement aramaSonucBasligi = driver.findElement(By.className("search-heading-title"));
        Assert.assertTrue(aramaSonucBasligi.getText().contains("java"));

        List<WebElement> kitapListesi = driver.findElements(By.xpath("//div[@class='grid_7 omega']"));
        for (WebElement kitap : kitapListesi) {
            Assert.assertTrue(kitap.getText().contains("java")
                    || kitap.getText().contains("Java")
                    || kitap.getText().contains("JAVA"));
        }
    }
}