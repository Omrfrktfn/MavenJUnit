package SSG.day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_FilesUpload extends TestBase {

    @Test
    public void test01() {

        // masaustunde bir deneme dosyası olusturun. İcine Merhaba Dunya yazınız.
        // 'https://cgi-lib.berkeley.edu/ex/fup.html' adresine gidiniz
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
        wait(1);

        // 'Notes about the file' kısmına 'Benim Dosyam' notunu yazınız.
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Benim Dosyam");
        wait(1);

        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz.
        // "C:\Users\Omer     \OneDrive\Masaüstü\Yeni Metin Belgesi.txt"


        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\OneDrive\\Masaüstü\\Yeni Metin Belgesi.txt";
        String dosyaYolu = farkliKisim + ortakKisim;

        WebElement dosyaSec = driver.findElement(By.xpath("//input[@name='upfile']"));
        dosyaSec.sendKeys(dosyaYolu);


        // 'Press' butonuna basın
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        wait(1);
        // Dosya notunun 'Benim Dosyam' oldugunu test ediniz
        String dosyaNotu = driver.findElement(By.tagName("blockquote")).getText();
        Assert.assertEquals("Benim Dosyam", dosyaNotu);

        // Dosya iceriginin 'Merhaba Dunya' icerdigini test ediniz.


    }
}
