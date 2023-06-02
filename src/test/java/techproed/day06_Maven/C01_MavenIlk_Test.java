package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C01_MavenIlk_Test {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // 1. https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //2. arama kutusunu locate edelim
        //   driver.findElement(By.id("twotabsearchtextbox"));
        WebElement searchBox = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));

        //3. “Samsung headphones” ile arama yapalim
        searchBox.sendKeys("Samsung headphones", Keys.ENTER);

        // 4. Bulunan sonuc sayisini yazdiralim
        List<WebElement> sonucSayisi = driver.findElements(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        WebElement sonucYazisi = sonucSayisi.get(0);
        System.out.println(sonucYazisi.getText());

        String sonucSayisi1[] = sonucYazisi.getText().split(" ");
        System.out.println(Arrays.toString(sonucSayisi1));
        System.out.println(sonucSayisi1[2]);//2.index'te bulunan sayiyi aldik

        //5. Ilk urunu tiklayalim
        WebElement ilkUrun =driver.findElement(By.xpath("(//*[@class='s-image'])[1]"));
        ilkUrun.click();

        //6. Sayfadaki tum basliklari yazdiralim
        List<WebElement> pageNames= driver.findElements(By.xpath("//h1 |// h2"));
        pageNames.forEach(t-> System.out.println(t.getText()));

        driver.close();

    }

}
