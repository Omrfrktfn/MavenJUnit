package techproed.day22_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSExecuter_Type extends TestBase {

    @Test
    public void test01() {

        //  https://techproeducation.com sayfasına gidin
        driver.get("https://techproeducation.com");
        wait(1);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        wait(2);

        // Arama kutusuna "QA" yazıp aratın

        WebElement searchBox = driver.findElement(By.xpath("//*[@type='search']"));


        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='QA'",searchBox);
        wait(1);
        searchBox.submit();

       // click(searchBox);

       // js.executeScript("arguments[0].enter();", searchBox);


     //   sendKeysJS(searchBox,"QA");

        //olusturdugumzu value degerine herhangi bir atama islemi yapmaz
        //fakat asagidaki kodlarda calistirdiktan sonra incele yaptigimiz da value da degeri gorebiliriz


/*
        //Second way
        WebElement searchBox = driver.findElement(By.xpath("//*[@type='search']"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value' , 'QA')",searchBox);

 */

    }

    public void click(WebElement element) {
        try {
            element.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        }
    }
}
