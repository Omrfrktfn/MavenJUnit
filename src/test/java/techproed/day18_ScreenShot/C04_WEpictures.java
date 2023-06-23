package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C04_WEpictures extends TestBase {

    /*
    Bir webElement'in resmini almak icin once WebElement'in locate edip bir webElement'e assing ederiz
    ve bu webElement'i direk getScreenShotAs() methodunu kullanarak resmini belirttigimiz dosya ya kaydederiz.
     */
    @Test
    public void test01() throws IOException {

        //Amazon sayfasine gidelim
        driver.get("https://www.amazon.com");
        wait(1);

        //iphone aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //cikan sonuc reklami alalim

        WebElement resultWrite = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));

        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date()); // tarihle ilgili yeni bir format
        //  String dosyaYolu = "src/test/java/techproed/WebElementScreenShot//WEscreenShot" + date + ".jpeg";
        String dosyaYolu = "src/test/java/techproed/WebElementPictures/WEscreenShot" + date + ".jpeg";
        FileUtils.copyFile(resultWrite.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));

    }
}
