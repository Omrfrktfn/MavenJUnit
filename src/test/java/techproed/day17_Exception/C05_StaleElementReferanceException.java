package techproed.day17_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C05_StaleElementReferanceException extends TestBase {

    @Test
    public void test01() {

        // Amazon sayfasına gidelim
        driver.get("https://amazon.com");


        // arama motoruna iphone yazıp aratalım
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone" + Keys.ENTER);


        // cıkan sonuclardan ilk 5'ine tıklayıp sayfa baslıklarını alalım konsola yazdıralım
        List<WebElement> results = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
        for (int i = 0; i < results.size(); i++) {
            //iceride locate yeniden olmadigi icin navige.back isleminden sonra yeni locati de eklememiz gerekiyor.
            results.get(i).click();
            System.out.println(i + ".urun tittle :" + driver.getTitle());
            wait(1);
            driver.navigate().back();
            wait(1);

            if (i==4){
                break;
            }
        }
    }

    @Test
    public void test02() {

        // Amazon sayfasına gidelim
        driver.get("https://amazon.com");


        // arama motoruna iphone yazıp aratalım
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone" + Keys.ENTER);


        // cıkan sonuclardan ilk 5'ine tıklayıp sayfa baslıklarını alalım konsola yazdıralım
        List<WebElement> results = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
        for (int i = 0; i < results.size(); i++) {
            results = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
            results.get(i).click();
            System.out.println(i + ".urun tittle :" + driver.getTitle());
            wait(1);
            driver.navigate().back();
            wait(1);

            if (i==4){
                break;
            }
        }
    }
}
