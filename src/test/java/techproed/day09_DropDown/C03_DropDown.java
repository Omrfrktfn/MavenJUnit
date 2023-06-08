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

public class C03_DropDown {

    // Programlama Dili Dropdown'undan "Java" seciniz
    // Programlama Dili Dropdown'undan son secilen option'un "Java" oldugunu test ediniz
    // Programlama Dili Dropdown'undaki tum optionları konsolda yazdırınız

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

        WebElement ddm = driver.findElement(By.xpath("//*[@name='Languages']"));
        Thread.sleep(2000);
        Select option = new Select(ddm);
        option.selectByVisibleText("Java");
        Thread.sleep(1000);

        WebElement language = option.getFirstSelectedOption();
        String strLanguage = language.getText();
        Assert.assertEquals("Java", strLanguage);

        List<WebElement> tumLanguage = option.getOptions();
        tumLanguage.stream().forEach(t -> System.out.println(t.getText()));

        System.out.println("*****************************************************************");
        //sayfadaki tum DropwDown'lardaki tum opsiyonlari yazdiriniz.
        List<WebElement> tumDropDown = driver.findElements(By.tagName("option"));
        tumDropDown.stream().forEach(t -> System.out.println(t.getText()));

    }
}
