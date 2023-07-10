package SSG.day01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class GetKomutlari extends TestBase {

    //  https://www.kitapyurdu.com/ adresine gidiniz.
    //  Anasayfanın açıldığını sayfa URL’si ile doğrulayınız.
    //  Anasayfanın açıldığını sayfa başlığı ile doğrulayınız.
    //  Anasayfada "Haftanın Yayınevi", "En Çok Satılanlar" ve "Ayın Yayınevleri" başlıklarının bulunduğunu doğrulayınız.
    //  Üye girişi butonunun üzerindeki metnin "Giriş Yap" olduğunu doğrulayınız.
    //          “Üye Ol” butonunun linkinin "https://www.kitapyurdu.com/index.php?route=account/register" olduğunu doğrulayınız.
    //  En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin span tagı içerisinde olduğunu doğrulayınız.
    //  En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin font ailesinin "Arial, Helvetica, sans-serif" olduğunu doğrulayınız.
    //  Haftanın Yayınevi bölümündeki ilk kitabın resim genişliğinin 120, yüksekliğinin 174 olduğunu doğrulayınız.
    //  quit() ve close() metotları arasındaki farkı inceleyelim.


    @Test
    public void test01() {
        //  https://www.kitapyurdu.com/ adresine gidiniz.
        driver.get("https://www.kitapyurdu.com/");
        wait(1);

        //  Anasayfanın açıldığını sayfa URL’si ile doğrulayınız.
        String expectedUrl = "https://www.kitapyurdu.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

        //  Anasayfanın açıldığını sayfa başlığı ile doğrulayınız.
        String expectedTittle = "Kitapyurdu, Kitapla buluşmanın en kolay yolu";
        String actualTittle = driver.getTitle();
        Assert.assertEquals(expectedTittle, actualTittle);

        //  Anasayfada "Haftanın Yayınevi", "En Çok Satılanlar" ve "Ayın Yayınevleri" başlıklarının bulunduğunu doğrulayınız.
        String pageSource = driver.getPageSource(); // -->
        Assert.assertTrue(pageSource.contains("Haftanın Yayınevi"));
        Assert.assertTrue(pageSource.contains("En Çok Satılanlar"));
        Assert.assertTrue(pageSource.contains("Ayın Yayınevleri"));

        //  Üye girişi butonunun üzerindeki metnin "Giriş Yap" olduğunu doğrulayınız.
        WebElement enterButon = driver.findElement(By.xpath("//div[@class='menu-top-button login']"));
        String enterButonText = enterButon.getText();
        Assert.assertEquals("Giriş Yap", enterButonText);

        //   “Üye Ol” butonunun linkinin "https://www.kitapyurdu.com/index.php?route=account/register" olduğunu doğrulayınız.
        WebElement uyeOl = driver.findElement(By.linkText("Üye Ol"));
        String uyeOlHref = uyeOl.getAttribute("href");
        Assert.assertEquals("https://www.kitapyurdu.com/index.php?route=account/register", uyeOlHref);

        //  En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin span tagı içerisinde olduğunu doğrulayınız.
        List<WebElement> yazarIsmiName = driver.findElements(By.xpath("//span[@class='author line-clamp-2']"));
        for (WebElement w : yazarIsmiName) {
            Assert.assertEquals("span", w.getTagName());
        }

        //  En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin font ailesinin "Arial, Helvetica, sans-serif" olduğunu doğrulayınız.

        for (WebElement each : yazarIsmiName) {
            Assert.assertEquals("Arial, Helvetica, sans-serif", each.getCssValue("font-family"));
        }

        //  Haftanın Yayınevi bölümündeki ilk kitabın resim genişliğinin 120, yüksekliğinin 174 olduğunu doğrulayınız.
        WebElement kitapYayin= driver.findElement(By.xpath("(//*[@class='pr-img-link'])[1]"));
        int height= kitapYayin.getSize().getHeight();
        System.out.println(height);
        int width= kitapYayin.getSize().getWidth();
        System.out.println(width);
        int actualHeight = 198;
        int actualWeight = 128;
        Assert.assertEquals(height, actualHeight);
        Assert.assertEquals(width,actualWeight);

        //  quit() ve close() metotları arasındaki farkı inceleyelim.
        wait(1);
        driver.close();

    }
}
