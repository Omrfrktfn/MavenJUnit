package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_ScreenShot extends TestBase {

    @Test
    public void test01()throws IOException {

        //Techproeducation sayfasine gidelim
        driver.get("https://www.techproeducation.com");
        wait(1);

        //Cikan reklami kapatalim
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        wait(1);
        //Ve ekran goruntusunu alalim.
        takeScreenShot();

    }
}
