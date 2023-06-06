package techproed.day08_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforClass_AfterClass {

    /*
    @BeforeClass class'da en once calisan method'dur.
    @AfterClass class'da en son calican method'dur.
    @BeforeClass ve @AfterClass methodlari sadece static methodlar ile calisir.
     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Class'da en once calisan methoddur.");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Class'da en son calisan methoddur.");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her test methodundan once calisir.");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her test methodundan sonra calisir.");
    }


    @Test
    public void test01() {
        System.out.println("ilk test");
    }

    @Test
    public void test02() {
        System.out.println("ikinci test");
    }
}
