package SSG.day07;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;


public class Alert extends TestBase {


    @Test
    public void alert01() {

        driver.get("https://demoqa.com/alerts");
        wait(1);

        driver.findElement(By.id("alertButton")).click();
        wait(1);

        String str = driver.switchTo().alert().getText();
        System.out.println("Alert Metni : "+str);

        driver.switchTo().alert().accept();
        wait(2);

    }


    @Test
    public void alert02() {

        driver.get("https://demoqa.com/alerts");
        wait(1);

        driver.findElement(By.xpath("//*[@id='confirmButton']")).click();
        wait(1);

        driver.switchTo().alert().dismiss();
        wait(2);

    }

    @Test
    public void alert03() {

        driver.get("https://demoqa.com/alerts");
        wait(1);

        driver.findElement(By.xpath("//*[@id='promtButton']")).click();
        wait(1);

        driver.switchTo().alert().sendKeys("omer");
        wait(2);
        driver.switchTo().alert().accept();
        wait(2);

    }


    @Test
    public void alert04() {

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        wait(1);

        //Authentication (Kimlik Dogrulama Penceresi) - Basic
        //Digit Authentication (Sifreyi hashode a ceviren bir teknik kullanir)



    }


    @Test
    public void alert05() {

        driver.get("https://demoqa.com/alerts");
        wait(1);

        driver.findElement(By.xpath("//*[@id='timerAlertButton']")).click();
        wait(6);

        driver.switchTo().alert().accept();

    }



}
