package HomeWork;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C08 extends TestBase {
    @Test
    public void test01() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
//driver.switchTo().frame(0);
        frameIndex(0);
        WebElement drag=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop=driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();
    }

    @Test
    public void test02() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
//driver.switchTo().frame(0);
        frameIndex(0);
        WebElement drag=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop=driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(drag).moveToElement(drop).release().perform();
    }

    @Test
    public void test03() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
//driver.switchTo().frame(0);
        frameIndex(0);
        WebElement drag=driver.findElement(By.xpath("//*[@id='draggable']"));
       // WebElement drop=driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(drag).moveByOffset(155,70).release().perform();
    }
}
