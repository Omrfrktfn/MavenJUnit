package SSG.day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C01_FilesDownload extends TestBase {

    @Test
    public void test01() {

        // 'https://testpages.herokuapp.com/' adresine gidiniz
        driver.get("https://testpages.herokuapp.com/");
        wait(1);

        // File Downloads kısmına tıklayınız
        driver.findElement(By.xpath("//a[@id='download']")).click();
        wait(1);
        // Server Download dosyasini indirelim
        driver.findElement(By.xpath("//button[@id='server-download']")).click();

        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz
      //  "C:\Users\Omer   \Downloads\textfile.txt"

        String farkliKisim= System.getProperty("user.home");
        String ortakKisim= "\\Downloads\\textfile.txt";
        String dosyaYolu = farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
