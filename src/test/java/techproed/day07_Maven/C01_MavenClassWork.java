package techproed.day07_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenClassWork {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        Thread.sleep(2000);

        // Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();

        // Login alanina  "username" yazdirin
        WebElement login = driver.findElement(By.xpath("//*[@id='user_login']"));
        login.sendKeys("username");
        Thread.sleep(1000);

        // Password alanine "password" yazdirin
        WebElement password = driver.findElement(By.xpath("//*[@id='user_password']"));
        password.sendKeys("password");
        Thread.sleep(1000);

        // Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(1000);

        // Güvenlik problemini gecmek icin sayfada bir geri gelin
        driver.navigate().back();
        Thread.sleep(1000);

        // Online Banking bölümüne tıklamalın
        driver.findElement(By.xpath("//*[@id='online-banking']")).click();
        Thread.sleep(1000);

        // Pay Bills yazan kısıma tıklayın
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
        Thread.sleep(1000);

        // Amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount = driver.findElement(By.xpath("//*[@id='sp_amount']"));
        amount.sendKeys("100");
        Thread.sleep(1000);

        // Date kismina "2020-09-10" yazdirin
        WebElement date = driver.findElement(By.xpath("//*[@id='sp_date']"));
        date.sendKeys("2020-09-10");
        Thread.sleep(1000);

        // Pay buttonuna tiklayin
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(1000);

        // "The payment was successfully submitted." mesajinin ciktigini test edin
        WebElement actual = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
        if (actual.equals("The payment was successfully submitted.")){
            System.out.println("Test PASS");
        }else {
            System.out.println("Test FAIL");
        }

        // Sayfayi kapatın
        Thread.sleep(1000);
        driver.close();

    }
}
