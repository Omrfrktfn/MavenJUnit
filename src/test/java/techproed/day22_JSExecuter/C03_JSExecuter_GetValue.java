package techproed.day22_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecuter_GetValue extends TestBase {

    @Test
    public void test01() {

        //https://www.carettahotel.com/
        driver.get("https://www.carettahotel.com/");
        wait(1);

        driver.findElement(By.xpath("//*[@id='details-button']")).click();
        wait(1);
        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();

        //  https://www.carettahotel.com/ sayfasına gidiniz
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement date = (WebElement) js.executeScript("return document.getElementById('checkin_date')");
        wait(1);

        // WebElement cssSelctorDate = (WebElement) js.executeScript("return document.querySelector(\"input[id='checkin_date']\")");
        //  wait(1);

        // cssSelctorDate.submit();

        //checkinDate kismina 5/25/2023 tarihini yaziniz.

        date.clear();
        wait(1);
        date.sendKeys("5/25/2023");

        //checkinDate kisminin degerini yazdiriniz.
        String valueAttribute = (String) js.executeScript("return document.getElementById('checkin_date').value");
        System.out.println(valueAttribute);

        /*
        Eger bir web sayfasinda webelementler olusturulurken JS kullanilmissa, normal olarak
        locate almakta zorlanabiliriz. Bu gibi durumlarda JSExecutor kullanarak webelementi locate edebiliriz
         */


    }
}
