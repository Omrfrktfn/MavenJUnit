package techproed.day22_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_JSexecuter_Scroll extends TestBase {

    JavascriptExecutor js;

    @Test
    public void Test01() {

        //  https://techproeducation.com sayfasına gidin
        driver.get("https://techproeducation.com");
        wait(1);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        wait(2);

        // "We Offer" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
        // Actions action = new Actions(driver);
        // action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN)
        //         .perform();

        WebElement weOffer = driver.findElement(By.xpath("(//*[@class='thim-color'])[2]"));
        //  js = (JavascriptExecutor) driver;
        //  js.executeScript("arguments[0].scrollIntoView(true);", weOffer);//weOffer elementi gorunur olacak sekilde sayfayi kaydir.
        scroll(weOffer); // methdod ile cozumu
        wait(3);

        // Aynı sayfada "Enroll Free" elementi görünür olacak sekilde scroll et (sayfayı kaydır)
        WebElement enrollFree = driver.findElement(By.xpath("//span[text()='Enroll Free Course']"));
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", enrollFree);

        // scroll(enrollFree); // method ile cozumu

        wait(3);

        // Aynı sayfada tekrar "whyUs Free" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
        WebElement whyUs = driver.findElement(By.xpath("//*[text()='WHY US?']"));
        js.executeScript("arguments[0].scrollIntoView(true);", whyUs);
        wait(3);
        //scroll(whyUs);

        // Aynı sayfada "Enroll Free" elementi görünür olacak sekilde scroll et (sayfayı kaydır)
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", enrollFree);
        wait(3);


        // Sayfayi en üste scroll et (sayfayı kaydır)
        // js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

        scrollHome();
        wait(3);

        // Sayfayı en alta scroll et (sayfayı kaydır)
        // js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        scrollEnd();
    }
}
