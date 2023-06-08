package techproed.day09_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDown {

    // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz

    // Select a State Dropdown'undan "Arizona" seciniz

    // Select a State Dropdown'undan son secilen option'un "Arizona" oldugunu test ediniz

    // Select a State Dropdown'undaki tum optionları konsolda yazdırınız

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        WebElement ddm = driver.findElement(By.xpath("//*[@id='state']"));
        Thread.sleep(1000);
        Select option = new Select(ddm);
        option.selectByVisibleText("Arizona");
        Thread.sleep(1000);

        WebElement sonSecilenOption = option.getFirstSelectedOption();//son secilen obsiyonu getirir.
        //Assert icine string bir deger gircegimiz icin webElemnt i string cevirmeliyiz
        String str = sonSecilenOption.getText();
        Assert.assertEquals("Arizona", str);//son secilen urun arizona ise true olucak.


        List<WebElement> opsiyonlar = option.getOptions();

        for (WebElement each : opsiyonlar) {
            System.out.println(each.getText());
        }

        //  opsiyonlar.stream().forEach(t-> System.out.println(t.getText()));

/*
        //second way
        List<WebElement> tumOpsiyonlar = driver.findElements(By.xpath("//select[@id='state']//option"));
        tumOpsiyonlar.stream().forEach(t-> System.out.println(t.getText()));

 */

    }
}
