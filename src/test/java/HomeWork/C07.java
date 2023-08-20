package HomeWork;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C07 extends TestBase {
    @Test
    public void test01() {
        //Techproeducation sayfasına gidelim

        driver.get("https://techproeducation.com");

        //Sayfanın en altına scroll yapalım
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
   bekle(2);
        //Sayfanın en üstüne scroll yapalım

        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();




        //Techproeducation sayfasına gidelim



        // Events yazısına kadar scroll yapalım
    }

    @Test
    public void test02() {

        //Techproeducation sayfasına gidelim

driver.get("https://techproeducation");


// Sayfanın en altına scrol yapalım

Actions actions=new Actions(driver);
actions.sendKeys(Keys.END).perform();

actions.sendKeys(Keys.HOME).perform();

    }

    @Test
    public void test03() {
driver.get("https://techproeducation.com");

        // Events yazısına kadar scroll yapalım
        WebElement eventscroll =driver.findElement(By.xpath("(//h2)[1]"));

                Actions actions=new Actions(driver);
                actions.scrollToElement(eventscroll).perform();

}
}
