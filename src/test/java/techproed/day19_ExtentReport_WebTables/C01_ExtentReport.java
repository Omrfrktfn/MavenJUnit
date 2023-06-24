package techproed.day19_ExtentReport_WebTables;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentReport extends TestBase {

    ExtentReports extentReports; // --> Raporlamayi baslatmak icin kullanilan class
    ExtentHtmlReporter extentHtmlReporter;// -->Raporu HTML formatinda duzenler
    ExtentTest extentTest;// --> Test adimlarina eklemek istedigimiz bilgileri bu class ile olustururuz.

    @Test
    public void test01() {

        extentReports = new ExtentReports();
        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date()); // tarihle ilgili yeni bir format
        String dosyaYolu = "testOutput/extentReports/extentReport" + date + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);//-->HTML formatinda raporlamayi baslatacak.

        //Rapor da gozukmesini istedigimiz bilgiler icin
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Omer");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");

        extentTest = extentReports.createTest("ExtentTest", "Test Raporu");

        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        wait(2);
        extentTest.info("Amazon sayfasina gidildi.");

        //basligin amazon icerdgini test edelim
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        extentTest.info("Basligin amazon icerdigi test edildi.");

        //arama kutusunda iphone aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("arama kutusunda ipohone aratildi.");

        //sonuc yazisini konsola yadiralim
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("Sonuc Yazisi : "+sonucYazisi);
        extentTest.pass("Sonuc Yazisi consol'a yazdirildi...");
        extentTest.pass("sayfa kapatildi...");

        /*
        extentTest. objesi ile info methodunu kullanarak her step'te ne yaptigimizla alakali bilgi yazabiliriz.
        Testimizin en sonunda testin bittigini ifade eden pass() methodu ile testimiz ile alakali son bilgiyi
        ekleyebiliriz.
            Ve son olarak actions'daki gibi perform methodu gibi extentReport objesi ile flush() methodu kullanarak
            raporu sonlandiririz.
         */

        extentReports.flush(); // bu methodu kullanmazsak raporumuz olusmaz


    }
}
