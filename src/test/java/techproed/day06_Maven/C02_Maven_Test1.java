package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Maven_Test1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // 1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        Thread.sleep(2000);

        //2.Signin buttonuna tiklayin
        WebElement sigIn = driver.findElement(By.xpath("//*[@id='signin_button']"));
        sigIn.click();
        Thread.sleep(2000);

        //3.Login alanine “username” yazdirin
        WebElement login = driver.findElement(By.xpath("//*[@type='text']"));
        login.sendKeys("username");
        Thread.sleep(1000);

        //4.Password alanine “password” yazdirin
        WebElement password = driver.findElement(By.xpath("//*[@name='user_password']"));
        password.sendKeys("password");
        Thread.sleep(1000);

        //5.Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(1000);
        driver.navigate().back();

        //6.Online Banking altinda Pay Bills sayfasina gidin
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='online-banking']")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        Thread.sleep(1000);
        WebElement amount = driver.findElement(By.xpath("//*[@id='sp_amount']"));
        amount.sendKeys("1000");

        //8.tarih kismina “2020-09-10” yazdirin
        Thread.sleep(1000);
        WebElement date = driver.findElement(By.xpath("//*[@id='sp_date']"));
        date.sendKeys("2020-09-10");

        //9.Pay buttonuna tiklayin
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='pay_saved_payees']")).click();

        //10.“The payment was successfully submitted.” mesajinin ciktigini control edin
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath("(//*[.='The payment was successfully submitted.'])[2]"));
        if (element.isDisplayed()) {
            System.out.println("Test Pass");
        } else {
            System.out.println("Test Fail" + element);
        }

        Thread.sleep(1000);
        driver.close();
    }
}
