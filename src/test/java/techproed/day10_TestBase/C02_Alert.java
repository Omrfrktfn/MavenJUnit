package techproed.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_Alert extends TestBase {
 /*
    https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.


    Bir metod olusturun: acceptAlert
    1. butona tıklayın,
    uyarıdaki OK butonuna tıklayın
    ve result mesajının "You successfully clicked an alert" oldugunu test edin.



    Bir metod olusturun: dismissAlert
    2. butona tıklayın,
    uyarıdaki Cancel butonuna tıklayın
    ve result mesajının "successfuly" icermedigini test edin.



    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın,
    uyarıdaki mesajı konsolda yazdırın,
    uyarıdaki metin kutusuna isminizi yazin,
    OK butonuna tıklayın
    ve result mesajında isminizin görüntülendiğini doğrulayın.

     */

    @Test
    public void acceptAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        wait(2);

        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[1]")).click();
        wait(2);

        // driver.switchTo().alert().accept();   //switchTo gecmek degistirmek
        alertAccept();

        // WebElement sonuc = driver.findElement(By.xpath("//*[@id='result']"));
        // Assert.assertTrue(sonuc.getText().contains("You successfully clicked an alert"));
        String actualResult = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedResult = "You successfully clicked an alert";
        Assert.assertEquals(expectedResult, actualResult);
        wait(2);

    }

    @Test
    public void dismissAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        wait(2);

        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[2]")).click();
        wait(2);

        //  driver.switchTo().alert().dismiss();
        alertDismiss();

        String actualResult = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedResult = "successfuly";
        Assert.assertFalse(actualResult.contains(expectedResult));
        wait(2);

    }

    @Test
    public void sendKeysAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        wait(2);

        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[3]")).click();
        wait(2);

        // System.out.println(driver.switchTo().alert().getText());
        alertText();

        // driver.switchTo().alert().sendKeys("omer");
        alertPrompt("omer");

        //  driver.switchTo().alert().accept();
        alertAccept();

        String actualResult = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedResult = "omer";
        Assert.assertTrue(actualResult.contains(expectedResult));
        wait(2);
    }
}
