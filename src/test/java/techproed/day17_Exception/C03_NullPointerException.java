package techproed.day17_Exception;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;


public class C03_NullPointerException extends TestBase {

    WebDriver driver ;
    Faker faker ;
    Actions action;
    Integer sayi;
    String isim;

    @Test
    public void test01() {
        //driver = new ChromeDriver atamsini yapmadigimiz icin nullpoint hatasini aldik.
    driver.get("https://amazon.com");

    }

    @Test
    public void test02() {
        //faker = new Faker atamasini yapmadigimiz icin nullpoint hatasini aldik.
        System.out.println(faker.name().firstName());
    }

    @Test
    public void test03() {
        //actions = new Actions atamasini yapmadigimiz icin nullpoint hatasini aldik.
        action.doubleClick().perform();
    }

    @Test
    public void test04() {
        //sayi = new Integer atamasini yapmadigimiz icin NullPointerException hatasini aldik.
        System.out.println(sayi+5);
    }

    @Test
    public void test05() {
        //isim = new String atamasini yapmadigimiz icin NullPointerException hatasini aldik.
        System.out.println(isim.charAt(0));
    }
}
