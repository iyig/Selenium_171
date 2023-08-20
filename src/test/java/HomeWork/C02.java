package HomeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02 extends TestBase {

    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz

driver.get("https://the-internet.herokuapp.com/iframe");







        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız

        WebElement kalinYazi=driver.findElement(By.xpath("//h3"));
        String yazi=kalinYazi.getText();
        Assert.assertTrue(yazi.contains("Editor"));


        //Textbox içindeki yazıyı siliniz.

//driver.switchTo().frame("mce_0_ifr")
driver.switchTo().frame("mce_0_ifr");
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();

//Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.

textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");


//Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
driver.switchTo().defaultContent();

WebElement elementSelenium= driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));

Assert.assertTrue(elementSelenium.getText().contains("Elemental Selenium"));
    }
}
