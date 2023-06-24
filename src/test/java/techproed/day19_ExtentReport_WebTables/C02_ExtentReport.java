package techproed.day19_ExtentReport_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C02_ExtentReport extends TestBase {

    @Test
    public void test01() {

        extentReport("Chrome","Amazon Test");
        extentTest=extentReports.createTest("Extent Report","Test Raporu");

        //amazon sayfasina gidiniz.
        driver.get("https://amazon.com");
        extentTest.info("Amzon sayfasina gidildi.");

        //sayfanini resmini aliniz.
        takeScreenShot();
        extentTest.info("sayfanini resmi alindi.");

        //arama kutusunda iphone aratiniz.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("arama kutusunda ipohone aratildi.");
    }
}
