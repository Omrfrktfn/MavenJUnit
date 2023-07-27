package SSG.day08;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WindowHandle extends TestBase {

    @Test
    public void test01() {

        driver.get("https://letcode.in/windows");
        String firstWindow = driver.getWindowHandle();
        System.out.println("ilk sayfa handle degeri : " + firstWindow);
        wait(1);
        System.out.println("ilk pencere tittle : " + driver.getTitle());


        WebElement button = driver.findElement(By.xpath("//*[@id='home']"));
        button.click();
        wait(1);
        Set<String> windowsSet = driver.getWindowHandles();
        System.out.println("Tum pencere handle'lari : " + windowsSet);


        for (String window : windowsSet) {

            if (!window.equals(firstWindow)) {
                driver.switchTo().window(window);
                break;
            }

        }
        String SecondWindow = driver.getWindowHandle();
        System.out.println("ilk sayfa handle degeri : " + SecondWindow);
        System.out.println("ikinci pencere tittle : " + driver.getTitle());


        driver.switchTo().window(firstWindow);//ilk pencereye gecmek icin tekrardan
        System.out.println("ilk pencere tittle : " + driver.getTitle());

    }


    @Test
    public void test02() {
        driver.get("https://letcode.in/windows");
        wait(1);

        WebElement button = driver.findElement(By.xpath("//*[@id='home']"));
        button.click();
        wait(1);

        //  Set<String> windows = driver.getWindowHandles();

        Iterator<String> iterator = driver.getWindowHandles().iterator();

        String ilkPencere = iterator.next();
        String ikinciPencere = iterator.next();

        driver.switchTo().window(ikinciPencere);
        System.out.println(ikinciPencere);

        driver.switchTo().window(ilkPencere);
        System.out.println(ilkPencere);


    }

    @Test
    public void test03() {
        driver.get("https://letcode.in/windows");
        wait(1);

        WebElement button = driver.findElement(By.xpath("//*[@id='home']"));
        button.click();
        wait(1);
        Set<String> windows = driver.getWindowHandles();
        List<String> windowsList = new ArrayList<>(windows);
        System.out.println(windowsList);

        System.out.println("ilk pencere tittle : " + driver.getTitle());

        driver.switchTo().window(windowsList.get(1));

        System.out.println("ikinci pencere tittle : " + driver.getTitle());

    }

    @Test
    public void test04() {

        driver.get("https://www.kitapyurdu.com/index.php?route=account/register");
        wait(1);
        System.out.println("ilk pencre tittle : " + driver.getTitle());

        //  tha.england@fixedfor.com

        WebElement emailKutusu = driver.findElement(By.xpath("//*[@id='register-email']"));

        driver.switchTo().newWindow(WindowType.TAB);
        System.out.println("ikinci pencre tittle : " + driver.getTitle());

        driver.get("https://fakemail.net");
        System.out.println("ikinci pencre tittle : " + driver.getTitle());
        WebElement fakeEmail = driver.findElement(By.id("email"));
        String eposta = fakeEmail.getText();

        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        System.out.println(pencereler);

        driver.switchTo().window(pencereler.get(0));
        emailKutusu.sendKeys(eposta);


    }
}
