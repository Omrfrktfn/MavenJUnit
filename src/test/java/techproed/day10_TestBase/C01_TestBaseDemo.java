package techproed.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {

    @Test
    public void test01()  {
        //techproeducation sayfasına gidiniz
        driver.get("https://techproeducation.com");


        //Baslıgın "Bootcamp" icerdigini test ediniz
        String actualTittle = driver.getTitle();
        String expectedTittle = "Bootcamp";
        Assert.assertTrue(actualTittle.contains(expectedTittle));

    }
}
