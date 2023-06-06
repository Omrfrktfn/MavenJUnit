package techproed.day08_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Assertion {

    // 4 tane test methodu olusturun


// test04
// https://amazon.com sayfasına gidin
// sayfa baslıgının "kitap" icermedigini test edin

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://amazon.com");
    }

    @After
    public void tearDown() throws Exception {
           driver.close();
    }

    @Test
    public void test01() {
        // test01
// https://amazon.com sayfasına gidin
// sayfa baslıgının "Amazon" kelimesini icerdigini test edin


        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Amazon"));
    }

    @Test
    public void test02() {
        // test02
// https://amazon.com sayfasına gidin
// Amazon resminin görüntülendiğini (isDisplayed()) test edin

        WebElement picture = driver.findElement(By.xpath("//*[@id='nav-logo-sprites']"));
        Assert.assertTrue(picture.isDisplayed());
    }

    @Test
    public void test03() {
        // test03
// https://amazon.com sayfasına gidin
// arama kutusunun erisilebilir oldugunu test edin

        WebElement searcbox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        Assert.assertTrue(searcbox.isEnabled());
    }

    @Test
    public void test04() {
        // test04
// https://amazon.com sayfasına gidin
// sayfa baslıgının "kitap" icermedigini test edin

        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains("kitap"));

    }
}
