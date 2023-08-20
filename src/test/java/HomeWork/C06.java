package HomeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C06 extends TestBase {
    @Test
    public void test01() {
        // Amazon a gidelim
        driver.get("https://www.amazon.com/");

        // sag üst bölümünde bulunan Acoount & Lists menüsü git Account secenegi tıkla

        WebElement accountList=driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountList).perform();
        Assert.assertEquals("Your Account", driver.getTitle());

    }
}
