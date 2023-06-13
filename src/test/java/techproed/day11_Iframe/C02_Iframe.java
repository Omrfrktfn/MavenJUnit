package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Iframe extends TestBase {

    //==>  https://the-internet.herokuapp.com/iframe sayfasına gidiniz
//==>  Kalın yazının "Editor" kelimesini içerdiğini test ediniz
//==>  textBox içindeki yazıyı siliniz.
//==>  Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
//==>  Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.


    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        wait(2);

        WebElement yazi = driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(yazi.getText().contains("Editor"));

        WebElement iFrame = driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrame);
        driver.findElement(By.xpath("//p")).clear();
       // iFrame.clear();
        wait(2);
       // iFrame.sendKeys("");
        driver.findElement(By.xpath("//p")).sendKeys("Bu textbox iFrame içinde yer almaktadır");

        driver.switchTo().parentFrame();
        WebElement sonYazi = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(sonYazi.isDisplayed());

    }
}
