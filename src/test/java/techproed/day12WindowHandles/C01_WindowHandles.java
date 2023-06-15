package techproed.day12WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandles extends TestBase {

    @Test
    public void test01() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        wait(1);

        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfa = driver.getWindowHandle();
        System.out.println("Handle degeri : " + ilkSayfa);

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actual = driver.findElement(By.xpath("//h3")).getText();
        System.out.println("ilk sayfadaki text : " + actual);
        String expected = "Opening a new window";
        Assert.assertTrue(actual.equals(expected));

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTittle = driver.getTitle();
        System.out.println("ilk sayfa tittle : " + actualTittle);
        String expectedTiitle = "The Internet";
        Assert.assertTrue(actualTittle.equals(expectedTiitle));

        //  "Click Here" butonuna tıklayın.
        WebElement clikHere = driver.findElement(By.xpath("//*[text()='Click Here']"));
        clikHere.click();

        Set<String> WindowHandleSeti = driver.getWindowHandles();
        //Butun sekmeklerin handle degerini aldik ve foreach ile ikinci sayfadaki handle degeree ulastik

        /*
        hendiller.stream().
        filter(t->!t.equals(sayfa1Handle)).
        forEach(t-> System.out.println("IkinciSayfa : "+t));
         */
        String ikincaSayfaHandle = "";
        for (String each : WindowHandleSeti) {
            if (!each.equals(ilkSayfa)) {
                ikincaSayfaHandle = each;
            }
        }
        System.out.println("Ikindci Sayfa Handle degeri : " + ikincaSayfaHandle);
        driver.switchTo().window(ikincaSayfaHandle);

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        String actualTittle1 = driver.getTitle();
        System.out.println("ikinci sayfa Tittle : " + actualTittle1);
        String expectedTiitle1 = "New Window";
        Assert.assertTrue(actualTittle1.equals(expectedTiitle1));
        wait(1);

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(ilkSayfa);
        String actualTittle2 = driver.getTitle();
        String expectedTiitle2 = "The Internet";
        Assert.assertTrue(actualTittle2.equals(expectedTiitle2));
        wait(1);

        //  ikinci sayfaya tekrar geçin.
         driver.switchTo().window(ikincaSayfaHandle);
        wait(1);

        //  ilk sayfaya tekrar dönün.
          driver.switchTo().window(ilkSayfa);


    }
}
