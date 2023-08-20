package day08_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Iframe extends TestBase {

    @Test
    public void iframe() {

        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
//Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
//Textbox içindeki yazıyı siliniz.
//Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
//Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.

        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
      //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız

        WebElement kalinYazi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(kalinYazi.getText().contains("Editor"));

        //Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame("mce_0_ifr");
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();

        //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");

        //Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
        WebElement elementalSelenium = driver.findElement(By.xpath("(//a)[3]"));
        Assert.assertTrue(elementalSelenium.getText().contains("Elemental Selenium"));
    }
    }

