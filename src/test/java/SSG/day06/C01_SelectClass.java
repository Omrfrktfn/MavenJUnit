package SSG.day06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_SelectClass extends TestBase {


    @Test
    public void test01() {

        // letcode.in/dropdowns adresine gidin.
        driver.get("https://letcode.in/dropdowns");
        wait(1);

        //  Meyveler menüsünün tıklanabilir olduğunu doğrulayın.
        WebElement meyveler = driver.findElement(By.id("fruits"));
        Assert.assertTrue(meyveler.isEnabled());
        wait(1);

        //  Meyveler menüsünden Apple seçeneğini görünen metin ile seçin.
        Select select = new Select(meyveler);
        select.selectByVisibleText("Apple");
        wait(1);

        //  Seçilen seçeneğin Apple olduğunu doğrulayın.
        Assert.assertEquals("Apple", select.getFirstSelectedOption().getText());
        wait(1);

        //  Menüde seçilen seçeneği yazdırın.
        System.out.println(select.getFirstSelectedOption().getText());
    }
}
