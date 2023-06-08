package techproed.day09_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_DropDown {

    // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz

    // Yıl Drodown'undan "2020" seciniz

    // Ay Dropdown'undan "August" seciniz

    // Gün Dropdown'undan "5" seciniz

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

        WebElement ddm = driver.findElement(By.xpath("//*[@id='year']"));
        Thread.sleep(1000);
        Select option = new Select(ddm);
        option.selectByVisibleText("2020");
        Thread.sleep(1000);

        WebElement ddm1 = driver.findElement(By.xpath("//*[@id='month']"));
        Thread.sleep(1000);
        Select option1 = new Select(ddm1);
        option1.selectByVisibleText("August");
        Thread.sleep(1000);

        WebElement ddm2 = driver.findElement(By.xpath("//*[@id='day']"));
        Thread.sleep(1000);
        Select option2 = new Select(ddm2);
        option2.selectByVisibleText("5");
        Thread.sleep(1000);

    }
}
