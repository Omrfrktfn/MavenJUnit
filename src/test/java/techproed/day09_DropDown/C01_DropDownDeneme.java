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

public class C01_DropDownDeneme {

    /*
Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
-3 farklı test methodu oluşturalım
    1.Method:
        a. Yil,ay,gün dropdown menu'leri locate ediniz
        b. Select objesi olustur
        c. Select object i kullaarak 3 farkli sekilde secim yapiniz
    2.Method:
        a. Tüm eyalet isimlerini yazdıralım
    3.Method:
        a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

 */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @After
    public void tearDown() throws Exception {
         driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        WebElement year = driver.findElement(By.xpath("//*[@id='year']"));
        WebElement month = driver.findElement(By.xpath("//*[@id='month']"));
        WebElement day = driver.findElement(By.xpath("//*[@id='day']"));

        Select option = new Select(year);
        Select option1 = new Select(month);
        Select option2 = new Select(day);

        Thread.sleep(2000);
        option.selectByVisibleText("1997");
        Thread.sleep(2000);
        option1.selectByVisibleText("February");
        Thread.sleep(2000);
        option2.selectByVisibleText("6");

    }

    @Test
    public void test02() {
        List<WebElement> state = driver.findElements(By.xpath("//*[@id='state']"));
        state.stream().forEach(t-> System.out.println(t.getText()));

        System.out.println("******************************************");

        //select ile yazili second way
        WebElement eyaletler = driver.findElement(By.xpath("(//select)[5]"));
        Select option = new Select(eyaletler);
        option.getOptions().forEach(w-> System.out.println(w.getText()));
    }

    @Test
    public void test03() {
        WebElement state = driver.findElement(By.xpath("//*[@id='state']"));
        Select option = new Select(state);
        String clickArea = option.getFirstSelectedOption().getText();
        Assert.assertEquals("Select a State", clickArea);

    }
}
