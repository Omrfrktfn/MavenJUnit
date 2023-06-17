package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions_DragDrop extends TestBase {

    @Test
    public void test01() {

        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        wait(2);

        //And user moves the target element(Drag me to my target) in to  destination(Drop here

        WebElement iframe = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);

        WebElement droggable = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement droppable = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(droggable, droppable).build().perform();
       /*
            Eger bir hareketli webelementi tutup baska bir webelementin uzerine birakmak istersek
             suruklemek istedigimiz webelementi locate'ini alip uzerine birakacagimiz webelementin locate'ini de alarak
             dragAndDrop(source(kaynak),target(hedef)) methodu ile islemi gerceklestirebiliriz
         */

    }

    @Test
    public void test02() {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        wait(2);

        //And user moves the target element(Drag me to my target) in to  destination(Drop here

        WebElement iframe = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);

        WebElement droggable = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement droppable = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(droggable).
                moveToElement(droppable).release().perform();
    }

    @Test
    public void test03() {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        wait(2);

        //And user moves the target element(Drag me to my target) in to  destination(Drop here

        WebElement iframe = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);

        WebElement droggable = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement droppable = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(droggable).
                moveByOffset(84,28).//belirtmis oldugnumuz koordinatlara webElement'i tasir.
                release().perform();
    }
}
