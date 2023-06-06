package techproed.day08_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckboxClass {

    //https://the-internet.herokuapp.com/checkboxes
//b. Checkbox1 ve checkbox2 elementlerini locateedin.
//c. Checkbox1 seçili değilse onay kutusunu tıklayın
//d. Checkbox2 seçili değilse onay kutusunu tıklayın

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() throws InterruptedException {
        //https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");


        WebElement checkbox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        if (!checkbox1.isSelected()) {
            Thread.sleep(2000);
            checkbox1.click(); // Checkbox1 seçili değilse tıklayın
        }

        WebElement checkbox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
        if (checkbox2.isSelected()) {
            Thread.sleep(2000);
            checkbox2.click(); //Checkbox2 secili ise tikla
        }

    }

    @Test @Ignore("GEREKSIZ OLAN KISIM")
    public void test02() {
        driver.get("https://amazon.com");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
