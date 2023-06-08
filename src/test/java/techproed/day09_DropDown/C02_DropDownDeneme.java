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

public class C02_DropDownDeneme {
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
        bekle(2);
         driver.close();
    }

    @Test
    public void test01() {
        //programing languages ddm den istediginiz dort secenegi seciniz.

        WebElement diller = driver.findElement(By.xpath("(//select)[6]"));
        Select option = new Select(diller);

        option.selectByIndex(0);
        option.selectByIndex(1);
        option.selectByIndex(2);

        //Secili olanlari consol'a yazdir.
        option.getAllSelectedOptions().forEach(t -> System.out.println(t.getText()));

        //secili olanlari verify yapain
        Assert.assertEquals(3, option.getAllSelectedOptions().size());

        //Ssctigimiz seceneklerden ilkini yazdiralim
        System.out.println("*******************************");
        System.out.println("secilen secenekleren ilki : " + option.getFirstSelectedOption().getText());
        Assert.assertEquals("Java", option.getFirstSelectedOption().getText());

        //Sectigimiz seceneklerin hepsini kaldiralim
        bekle(3);
        option.deselectAll();

        //sendKeys methodu ile istedigimiz bir secenegi gonderelim
        diller.sendKeys("C#");

        System.out.println("*****************************************");
        //Visible olarak secim yapacagimiz bir method olusturup programing languag ddm'dan menuden bir secenek secelim
        selcetVisibleText(diller, "Java");

        //index olarak secim yapacagimiz bir method olusturup programing languag ddm'dan menuden bir secenek secelim
        selectIndex(diller, 2);

        //value olarak secim yapacagimiz bir method olusturup programing languag ddm'dan menuden bir secenek secelim
        selectValue(diller, "js");


    }

    public void selcetVisibleText(WebElement ddm, String secenek) {
        Select option = new Select(ddm);
        option.selectByVisibleText(secenek);
    }

    public void selectIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    public void selectValue(WebElement ddm, String value) {
        Select select = new Select(ddm);
        select.selectByValue(value);
    }

    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
