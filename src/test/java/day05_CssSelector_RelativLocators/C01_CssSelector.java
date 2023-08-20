package day05_CssSelector_RelativLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_CssSelector {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //Add Element butonuna basın
        WebElement addElementButton=driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        addElementButton.click();
        Thread.sleep(3000);

        //Delete butonu'nun görünür oldugunu test edin

        WebElement deleteButtuon=driver.findElement(By.cssSelector("button[class='added-manually']"));

        if (deleteButtuon.isDisplayed()) {
            System.out.println("TEST PASSED");

        }else System.out.println("Test Failed");


        // Delete tusuna basin
        deleteButtuon.click();
        Thread.sleep(3000);


        // Add/Remove Elements yazısını alın

        WebElement addrmoveElement= driver.findElement(By.cssSelector("h3"));
        if (addrmoveElement.isDisplayed()){
            System.out.println("Test Passed");
        }else System.out.println("test Failed");

        driver.close();
/*
/*
ÖDEV:
https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
Add Element butonuna basin 100 kez basınız
Delete butonuna 90 kez basınız
Ve 90 kez basıldığını doğrulayınız


 */


    }

}
