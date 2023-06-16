package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Arrays;
import java.util.Set;

public class C01_Cookies extends TestBase {

    @Test
    public void test01() {

        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");
        wait(1);

        //2-tum cookie’leri listeleyin
        /*
        Cookie'leri listelemek istersek
        driver.manage().getCookies(); methoduyla bir set yada ArrayList'e atarak listeleyebiliriz.
         */

        // Arrays.stream(driver.manage().getCookies().toArray()).forEach(System.out::println);//lambda ile

        Set<Cookie> cookieSet = driver.manage().getCookies();
        int sayac = 1;
        for (Cookie cookie : cookieSet) {
            // System.out.println(sayac + " . cookie=" + cookie);
            System.out.println(sayac + " .cookie name : " + cookie.getName());
            System.out.println(sayac + " .cookie value : " + cookie.getValue());
            //getname ile ismi aliriz getvalue ile degeri aliriz,task'e gore belirlenir.
            sayac++;
        }

        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        System.out.println("Cookiler'in sayisi : " + cookieSet.size());
        Assert.assertTrue(cookieSet.size() > 5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        String expectedCookieValue = "USD";
        Assert.assertEquals(expectedCookieValue, actualCookieValue);

        // 5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie", "cikilatali");
        driver.manage().addCookie(cookie);

        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        cookieSet = driver.manage().getCookies();
        for (Cookie each : cookieSet) {
            System.out.println(each);
        }
        Assert.assertEquals("cikilatali", driver.manage().getCookieNamed("en sevdigim cookie").getValue());
        System.out.println("Cooki'lerin sayisi : " + cookieSet.size());
        //  System.out.println("Cookilerin sayisi : " + Arrays.stream(driver.manage().getCookies().toArray()).count());

        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        int silinmedenOnce = cookieSet.size();
        System.out.println("silinmeden once cookies sayisi : " + silinmedenOnce);
        wait(1);
        driver.manage().deleteCookieNamed("skin");//-->ismi skin olan cookie'yi sildik
        wait(1);

        cookieSet = driver.manage().getCookies();
        for (Cookie each : cookieSet) {
            System.out.println(each);
        }

        int silindiktenSonra = cookieSet.size();
        System.out.println("silindikten sonra cookies sayisi : " + silindiktenSonra);
        Assert.assertEquals(1, (silinmedenOnce - silindiktenSonra));

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();//Tum cookie'leri sildik
        cookieSet = driver.manage().getCookies();//tekrar cookieSet'i guncelledik
        Assert.assertTrue(cookieSet.isEmpty());//Ve cookieSet'in icinin bos oldugunu isEmpty() methoduyla test ettik.

    }
}
