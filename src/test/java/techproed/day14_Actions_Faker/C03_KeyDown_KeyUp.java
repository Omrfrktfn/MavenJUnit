package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_KeyDown_KeyUp extends TestBase {

    @Test
    public void test01() {


//Google anasayfasına gidelim
        driver.get("https://google.com");
        wait(1);
        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();

//arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        Actions action = new Actions(driver);
        action.keyDown(aramaKutusu, Keys.SHIFT).//Arama kutusunda  shift tusuna bastik ve buyuk harfle yazdi
                sendKeys("selenium").
                keyUp(Keys.SHIFT).sendKeys(" - java", Keys.ENTER).perform();

    }

    @Test
    public void tsst02() {
//Google anasayfasına gidelim
        driver.get("https://google.com");
        wait(1);
        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();

//arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys(Keys.SHIFT, "selenium", Keys.SHIFT, " - java", Keys.ENTER);
        /*
    Mause işlemleri için actions class'ını kullanmamız gerekir. Fakat bir metin kutusundaki klavye işlemleri için
    actions class'ına kullanmadan sendKeys() methodu ile de istediğimiz bir metni büyük yazdırabilir,
    hatta bir den fazla klavye tuşlana bastırabiliriz. Yukardaki örnekte sendKeys() methodu ile Keys.SHIFT diyerek
    sonrasında yazdırmak istediğimiz metni küçük harfle yazmamıza rağmen büyük harflerle yazdırdı, tekrar Keys.SHIFT
    kullanarak shift tuşunu serbest bırakmış olduk
     */

    }

    @Test
    public void test03() {
        //google sayfasına gidelim
        driver.get("https://google.com");
        wait(1);
        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();

// Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys(Keys.SHIFT, "selenium");
        aramaKutusu.submit();

// Sayfayı bekleyin
        wait(2);

// Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"a");//sayfa yenilendigi icin yeniden locate alip secme islemi yaptik.

        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"x");
        wait(1);

//Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım

        driver.navigate().back();
        aramaKutusu.sendKeys(Keys.CONTROL,"v");
        aramaKutusu.submit();

    }
}
