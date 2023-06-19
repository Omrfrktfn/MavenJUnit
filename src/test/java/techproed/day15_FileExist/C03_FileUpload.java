package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;

public class C03_FileUpload extends TestBase {

    @Test
    public void test01() {

        // masaustunde bir deneme dosyası olusturun
//"C:\Users\Omer\OneDrive\Masaüstü\deneme.txt"

        // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/upload");
        wait(2);

        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='file-upload']"));
        //dosyaSec.click();//selenium bilgisayara erisemedigi icin sendkeys ile gonderme islemi yaptik
      //  dosyaSec.sendKeys("C:\\Users\\Omer\\OneDrive\\Masaüstü\\deneme.txt");

        String ortakKisim= System.getProperty("user.home");
        System.out.println(ortakKisim);
        String farkliKisim = "\\OneDrive\\Masaüstü\\deneme.txt";
        String yol= ortakKisim+ farkliKisim;
        System.out.println(yol);
        dosyaSec.sendKeys(yol);

        wait(1);

        // 'Upload' butonuna basın
        driver.findElement(By.xpath("//*[@class='button']")).click();
        wait(1);

        // 'File Uploaded!' yazısının goruntulendigini test edin
        WebElement yazi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(yazi.isDisplayed());
    }
}
