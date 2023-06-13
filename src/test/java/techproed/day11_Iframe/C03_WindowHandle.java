package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_WindowHandle extends TestBase {
//  https://www.techproeducation.com adresine gidiniz
//  Title'ın "Techpro Education | Online It Courses & Bootcamps" olduğunu test edin

//  Yeni bir pencere acıp,  https://www.youtube.com sayfasına gidiniz

//  Yeni bir pencere acıp, https://www.linkedin.com sayfasına gidiniz

//  techproeducation sayfasına geçiniz
//  youtube sayfasına geçiniz
//  linkedIn sayfasına geçiniz:

    @Test
    public void test01() {
        driver.get("https://www.techproeducation.com");

        String techproWindowHandle = driver.getWindowHandle();
        System.out.println("Techpro Handle : " + techproWindowHandle);
        /*
        sayfanin handle degerinin getWindowHandle() method ile elde edebiliriz
         */

        String pageTittle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertTrue(pageTittle.contains(expectedTitle));

        wait(2);

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");

        String youtubeWindowHandle = driver.getWindowHandle();
        System.out.println("Youtube Handle : "+youtubeWindowHandle);

        wait(2);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");

        String linkedinWindowHandle = driver.getWindowHandle();
        System.out.println("linked Handle : "+linkedinWindowHandle);


        driver.switchTo().window(techproWindowHandle);
        wait(1);
        driver.switchTo().window(youtubeWindowHandle);
        wait(1);
        driver.switchTo().window(linkedinWindowHandle);

        /*
        windowType.Tab = yeni sekme acar
        windowTYpe.Window = yeni pencere acar
         */
    }
}
