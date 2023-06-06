package techproed.day08_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class C03_BeforeClassAfterClass {

    WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Amazon testi baslatildi.");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Amazon testi sonuclandi.");
    }

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://amazon.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Samsung" + Keys.ENTER);
    }

    @Test
    public void test02() throws InterruptedException {
        driver.get("https://amazon.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Iphone" + Keys.ENTER);
    }
}
