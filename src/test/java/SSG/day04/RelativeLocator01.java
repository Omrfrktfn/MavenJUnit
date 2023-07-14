package SSG.day04;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocator01 extends TestBase {

    Faker faker = new Faker();
    String password = faker.internet().password();

    @Test(timeout = 5000)
    public void relativeLocatorsTesti(){
        driver.get("https://www.kitapyurdu.com/");
        driver.findElement(By.linkText("Üye Ol")).click();

        WebElement adKutusu = driver.findElement(By.id("register-name"));
        adKutusu.sendKeys(faker.name().firstName());

        WebElement soyadKutusu = driver.findElement(with(By.tagName("input")).below(adKutusu));
        soyadKutusu.sendKeys(faker.name().lastName());

        WebElement epostaKutusu = driver.findElement(with(By.tagName("input")).below(soyadKutusu));
        epostaKutusu.sendKeys(faker.internet().emailAddress());

        WebElement sifre = driver.findElement(with(By.tagName("input")).below(epostaKutusu));
        sifre.sendKeys(password);

        WebElement sifreTekrar = driver.findElement(with(By.tagName("input")).below(sifre));
        sifreTekrar.sendKeys(password);

        WebElement kabul1 = driver.findElement(with(By.tagName("div")).below(sifreTekrar));
        kabul1.click();

        WebElement kabul2 = driver.findElement(with(By.tagName("div")).below(kabul1));
        kabul2.click();

        WebElement uyeOlButonu = driver.findElement(with(By.tagName("button")).below(kabul2));
        uyeOlButonu.click();

    }
}
