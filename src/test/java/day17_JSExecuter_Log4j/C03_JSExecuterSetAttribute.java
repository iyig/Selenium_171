package day17_JSExecuter_Log4j;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecuterSetAttribute extends TestBase {
    @Test
    public void test01() {
    //amazon sayfasına gidelim

       driver.get("https://amazon.com");

       /*
        Webdriver ile sendkeys() methodu kullanarak <input> tagına sahip bir webelemente text gönderebiliriz
        sendkeys() methodu ile gönderemedigimiz durumlarda aşagıdki örnekteki gibi js executer ile bunu yapabiliriz
 */

        //arama kutusuna java yazdıralım
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='java'",aramaKutusu);
    }

    @Test
    public void test02() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //arama Kutusu id attribu değerini ismimiz ile değiştirelim
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('id','ugur')",aramaKutusu);

        //Ve arama kutusunda değiştirdiğimiz attribute ile java aratalım
        driver.findElement(By.id("ugur")).sendKeys("java");
    }

    @Test
    public void test03() {

         //arama sayfasına gidelim
        driver.get("https://amazon.com");

         //arama kutusuna iphone yazdıralım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        jsSendKeys(aramaKutusu,"iphone");
    }
}
