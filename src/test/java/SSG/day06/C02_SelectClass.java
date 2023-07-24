package SSG.day06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C02_SelectClass extends TestBase {

    @Test
    public void test02() {

        //  letcode.in/dropdowns adresine gidin.
        driver.get("https://letcode.in/dropdowns");
        wait(1);

        //  Programlama Dilleri menüsünün tıklanabilir olduğunu doğrulayın.
        WebElement programlamaDilleri = driver.findElement(By.xpath("//*[@id='lang']"));
        Assert.assertTrue(programlamaDilleri.isEnabled());
        wait(1);

        //  Menüdeki son seçeneği seçin.
        Select select = new Select(programlamaDilleri);
        List<WebElement> pdList = select.getOptions();
        select.selectByIndex(pdList.size() - 1);

        //second way
        // Select select = new Select(programlamaDilleri);
        // select.selectByVisibleText("C#");
        wait(1);

        //  Seçilen seçeneğin C# olduğunu doğrulayın.
        Assert.assertEquals("C#", select.getFirstSelectedOption().getText());
        wait(1);

        //  Listede C++ seçeneğinin olmadığını doğrulayın.
        for (WebElement programDili : pdList) {
            Assert.assertFalse(programDili.getText().contains("C++"));
        }


        //  Menüdeki tüm elemanları yazdırın.
        for (WebElement programDili : pdList) {
            System.out.println("tum liste: " + programDili.getText());
        }

    }


    @Test
    public void test03() {

        //   letcode.in/dropdowns adresine gidin.
        driver.get("https://letcode.in/dropdowns");
        wait(1);

        //  Kahramanlar menüsünün, çoklu seçim yapılabilen bir menü olduğunu doğrulayın.
        WebElement kahramanlar = driver.findElement(By.id("superheros"));
        Select select = new Select(kahramanlar);
        Assert.assertTrue(select.isMultiple());

        //  Kahramanlar menüsünden 3 tane kahramanı index numaraları ile seçin.
        select.selectByIndex(3);
        select.selectByIndex(5);
        select.selectByIndex(7);

        //  Menüde 3 elemanın seçili olduğunu doğrulayın.
        Assert.assertEquals(3, select.getAllSelectedOptions().size());
        wait(1);

        //  Menüde seçili elemanlarının isimlerini doğrulayın.
        List<WebElement> heroList = select.getAllSelectedOptions();
        for (WebElement hero : heroList) {
            Assert.assertTrue (hero.getText().contains("Batman")||
                    hero.getText().contains("Black Panther") ||
                    hero.getText().contains("Captain Marvel"));
        }

        //  Seçili elemanlardan birinin seçimini kaldırın.
        select.deselectByIndex(3);
        wait(1);

        //  Menüde 2 elemanın seçili olduğunu doğrulayın.
        Assert.assertEquals(2, select.getAllSelectedOptions().size());
        wait(1);

        //  Menüde seçili elemanlarının isimlerini doğrulayın.
        heroList = select.getAllSelectedOptions();
        for (WebElement hero : heroList) {
            Assert.assertTrue (hero.getText().contains("Black Panther") ||
                    hero.getText().contains("Captain Marvel"));
        }
        wait(1);

        //  Seçili elemanların hepsinin seçimini kaldırın.
        select.deselectAll();
        wait(1);

        //  Menüde hiçbir elemanın seçili olmadığını doğrulayın.
        Assert.assertEquals(0, select.getAllSelectedOptions().size());
    }

    @Test
    public void test04() {
        //  letcode.in/dropdowns adresine gidin.
        driver.get("https://letcode.in/dropdowns");
        wait(1);

        WebElement meyveler = driver.findElement(By.id("fruits"));
        wait(1);

        meyveler.click();
        wait(2);

        WebElement optionToSelect = driver.findElement(By.xpath("//*[@value='0']"));
        optionToSelect.click();


    }
}
