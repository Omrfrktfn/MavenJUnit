package techproed.day17_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {

    @Test
    public void test01() {

        //techproeducation sayfasina gidiniz
        driver.get("https://techproeducation.com");
        wait(1);

        //reklami kapatin
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        wait(1);

        //searchBox'a java yazip aratalim
        driver.findElement(By.xpath("//*[@class='elementor-search-form__input']")).sendKeys("java", Keys.ENTER);

        //Eger locatir da yanlislik yaparsak NoSuchElementException hatasi aliriz
        // driver.findElement(By.xpath("//*[@class='fdaselementor-search-form__input']")).sendKeys("java", Keys.ENTER);

    }
}
