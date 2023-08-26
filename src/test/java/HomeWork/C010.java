package HomeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C010 extends TestBase {
//https://demoqa.com/ url'ine gidin.
//Alerts, Frame & Windows Butonuna click yap
//""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
//Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
//New Tab butonunun görünür olduğunu doğrula
//New Tab butonuna click yap
//Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
//İlk Tab'a geri dön
//New Tab butonunun görünür olduğunu doğrula

    @Test
    public void test() {
        //https://demoqa.com/ url'ine gidin.
driver.get("https://demoqa.com/");


//Alerts, Frame & Windows Butonuna click yap
        WebElement alertFrameWindows=driver.findElement(By.xpath("(//div[@class='card-body'])[3]"));
alertFrameWindows.click();

//""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']")).isDisplayed();


//Sol'da açılan Menu den ""Browser Windows"" butonuna click yap

driver.findElement(By.xpath("(//li[@id='item-0'])[3]")).click();

//New Tab butonunun görünür olduğunu doğrula
String actual =driver.findElement(By.xpath("//div[@id='tabButtonWrapper']")).getText();
String expected= "New Tab";
        Assert.assertEquals(expected,actual);
//New Tab butonuna click yap

driver.findElement(By.xpath("//button[@id='tabButton']")).click();
bekle(2);
//Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
bekle(2);
window(1);
String text=driver.findElement(By.xpath("//h1")).getText();
Assert.assertEquals(text,"This is a sample page");
bekle(2);
//İlk Tab'a geri dön
window(0);

        //New Tab butonunun görünür olduğunu doğrula
        String text1=driver.findElement(By.xpath("//button[@id='tabButton']")).getText();
        Assert.assertEquals(text1,"New Tab");
bekle(2);
    }
}
