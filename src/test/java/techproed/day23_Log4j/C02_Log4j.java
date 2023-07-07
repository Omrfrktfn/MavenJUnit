package techproed.day23_Log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_Log4j extends TestBase {

    @Test
    public void test01() {

        Logger logger = LogManager.getLogger(C02_Log4j.class);
        //Texhproeducation sayfasina gidelim
        driver.get("https://techproeducation.com/");
        wait(1);
        logger.info("Techpro sayfasina gidildi.");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        wait(1);
        logger.info("Sayfada cikan reklam kapatildi.");

        //basligin egitim icerdigini dogrulayalim
        Assert.assertFalse(driver.getTitle().contains("egitim"));
        logger.error("sayfa basligi egitim yazisi icermiyor.");


    }
}
