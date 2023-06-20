package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class TestBase {
    //abstract class yaptik cunku obje olusturulmasini istemiyoruz , depo olarak kullanacagiz.
    //Bu class'a extend ettigimiz test class'larindan ulasabiliriz.
    //TestBase class'indan obje olusturulmasinin onune gecilmesi icin abstract class yapilabilir.

    protected WebDriver driver;
    //olusturudugumuz driver'i kullanabilmemiz icin protected yaptik.

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
      //  driver.quit();
    }

    public void wait(int seconds) {

        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    //visibilityOf(element) methodu
    public void visibileWait(WebElement element, int saniye){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //visibilityOf(locator) methodu
    public void visibileWait(By locator, int saniye){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //alertWait
    public void alertWait(int saniye){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    //FluentWait visible method
    public void fluentWaitVisible(WebElement element, int saniye , int salise){
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(saniye)).
                pollingEvery(Duration.ofMillis(salise)).
                until(ExpectedConditions.visibilityOf(element));
    }

    public void alertAccept(){
        driver.switchTo().alert().accept();
    }

    public void alertDismiss(){
        driver.switchTo().alert().dismiss();
    }

    public void alertPrompt( String text){
        driver.switchTo().alert().sendKeys(text);
    }

    public void alertText (){
        System.out.println(driver.switchTo().alert().getText());
    }

    public void ddmVisibleText(WebElement ddm, String secenek){
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }

    public void ddmIndex (WebElement ddm , int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    public void ddmValue (WebElement ddm , String value) {
        Select select = new Select(ddm);
        select.selectByValue(value);
    }


}
