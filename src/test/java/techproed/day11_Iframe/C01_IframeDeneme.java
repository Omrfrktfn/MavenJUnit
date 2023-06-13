package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_IframeDeneme extends TestBase {
    //➢ https://testcenter.techproeducation.com/index.php?page=iframe
//➢    Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin   oldugunu test edelim
//➢    Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
//➢    Son olarak footer daki 'Povered By' yazisini varligini test edilip


    @Test
    public void test01() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        wait(2);

        String metin = driver.findElement(By.xpath("(//p)[1]")).getText();
        System.out.println(metin);
        String expected = "black border";
        Assert.assertTrue(metin.contains(expected));

        WebElement iFrame = driver.findElement(By.xpath("//*[@style='border:1px solid black;']"));
        driver.switchTo().frame(iFrame);
        wait(2);
        String iframeMetin = driver.findElement(By.xpath("//h1")).getText();
        System.out.println(iframeMetin);
        Assert.assertEquals("Applications lists", iframeMetin);

        driver.switchTo().parentFrame();

        WebElement sonYazi = driver.findElement(By.xpath("(//p)[3]"));
        Assert.assertTrue(sonYazi.isDisplayed());

    }
}
