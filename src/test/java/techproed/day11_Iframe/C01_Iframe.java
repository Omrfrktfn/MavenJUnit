package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {

    //==>   https://testcenter.techproeducation.com/index.php?page=iframe
//==>  Ana sayfadaki 'An iframe with a thin black border:' yazısının 'black border' icerdigini test edin
//==>  icteki web sayfasında 'Applications lists' yazisinin görünür oldugunu test edelim
//==>   Ana sayfadaki'Povered By' yazisinin "Povered" icerdigini test edin


    @Test
    public void iframe() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        wait(2);

        WebElement anIframeYazisi = driver.findElement(By.xpath("//p[text()='An iframe with a thin black border:']"));
        Assert.assertTrue(anIframeYazisi.getText().contains("black border"));

        /*
        Application lists yazisini dogru locate edip dogru bir sekilde gorunur oldugunu test etmemize ragmen
        ilk basta faild oldu bunun uzerine HTML kodlarini inceleyince Applications Lists yazisinin aslinda bir iframe icerisinde
        oldugunu gorduk. Bu durumda once iframe'i locate edip switchto ile iframe gecmeliyiz.
         */
        WebElement iFrame = driver.findElement(By.xpath("//*[@style='border:1px solid black;']"));
        driver.switchTo().frame(iFrame);
        WebElement iceridekiIframeYazisi = driver.findElement(By.xpath("//*[text()='Applications lists']"));
        Assert.assertTrue(iceridekiIframeYazisi.isDisplayed());

        //parentFrame bir ust seviyedeki iframe cikmak icin kullanilir.Default
        //defaultContent(); --> en ustteki iframe'e cikmak icin kullanilir.
        driver.switchTo().parentFrame();
        WebElement sonYazi = driver.findElement(By.xpath("(//p)[3]"));
        Assert.assertTrue(sonYazi.getText().contains("Povered"));

    }
}
