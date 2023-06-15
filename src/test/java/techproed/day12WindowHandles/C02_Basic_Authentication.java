package techproed.day12WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Basic_Authentication extends TestBase {
    /*
    -Authentication kimlik dogrulama yontemidir.
    -Soz konusu sisteme dahil olup olunamayacagini belirleyen formu ifade eder.
    -Authentication uzerinde sag clik yapip locate alinamaz.
    -Authentication bir allert degildir.
    -Authentication yapabilmek icin uygulamanin kullanicilara, Authentication'i nasi yapbilecegine dair
    bilgilendirme yapmis olmasi gerekir.

     */

    @Test
    public void test01() {
        // Aşağıdaki bilgileri kullanarak authentication yapınız:

          /*
        https://username:password@URL
        Yukaridaki belirtilen formata uygun kimlik dogrulamasi yapilacaktir.
         */

        // Url: https://the-internet.herokuapp.com/basic_auth
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        wait(1);



        // Username: admin


        // Password: admin


        //Paragrafın "Congratulations" kelimesini içerdiğini doğrulayınız


        WebElement word = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(word.getText().contains("Congratulations"));
    }
}
