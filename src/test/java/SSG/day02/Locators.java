package SSG.day02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.util.List;

public class Locators extends TestBase {

    @Test
    public void test01() {

        // https://www.kitapyurdu.com/ adresine gidiniz.
        driver.get("https://www.kitapyurdu.com/");
        wait(1);

        // “En Çok Satılanlar” bölümündeki ilk ürünü seçiniz.
        List<WebElement> encokSatilanlarList = driver.findElements(By.className("bestseller-item"));
        // System.out.println(encokSatilanlarList.get(0).getText());//ilk kitap bilgileri gelir
        String ilkKitap = encokSatilanlarList.get(0).getText().split("\n")[0];
        System.out.println(ilkKitap);
        encokSatilanlarList.get(0).click();// ilkurune tiklar , sistem de urun degisse bile bu sekilde bize hep ilkini verir
        wait(1);

        // Seçilen ürüne ait sayfanın açıldığını doğrulayınız.
        WebElement kitapAdi = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(ilkKitap, kitapAdi.getText());

        // "Devamını Oku…" butonuna basınız.
        WebElement devaminiOku = driver.findElement(By.partialLinkText("Devamı"));
        devaminiOku.click();
        wait(1);

        // Ürünü sepete ekleyiniz.
        WebElement sepeteEkle = driver.findElement(By.linkText("Sepete Ekle"));
        sepeteEkle.click();
        wait(1);

        // Sepete gidiniz.
        WebElement sepeteGit = driver.findElement(By.linkText("sepetinize"));
        sepeteGit.click();
        wait(1);

        // Ürüne ait kontrol kutusunu işaretleyiniz.
        WebElement urunKontrol = driver.findElement(By.name("cart_selection[]"));
        Assert.assertFalse(urunKontrol.isSelected());

        if (!urunKontrol.isSelected()){
            urunKontrol.click();
        }

        // Ürün miktarını değiştiriniz.
        WebElement urunMiktari = driver.findElement(By.name("quantity"));
        Assert.assertEquals("1", urunMiktari.getAttribute("value"));
        urunMiktari.clear();
        urunMiktari.sendKeys("3");
        Assert.assertEquals("3", urunMiktari.getAttribute("value"));
    }
}
