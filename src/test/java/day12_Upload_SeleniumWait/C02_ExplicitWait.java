package day12_Upload_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitWait extends TestBase {

    @Test
    public void test01() {
  /*
SELENIUM WAIT:
    IMPLICITLY WAIT : Driver'i oluşturduktan sonra sayfadaki tüm elementlerin etkileşime girebilmesi için
    belirtilmiş olduğumuz max. süre kadar bekler (Duration.ofSecond(15)).

EXPLICT WAIT / WebDriverWait --> Bir webelementin sayfa yüklendikten sonra etkileşime girebilmesi için
    max. belirtmiş olduğumuz süre kadar default olarak yarım saniyelik aralıklar ile bekler. Örneğin bir
    webelemente tıkladıktan sonra bir alert'ün yada bir webelementin oluşması zaman alabilir. Ve testimizi
    her çalıştırdığımızda bu zaman değişkenlik gösterebilir dolayısıyla bu gibi durumlarda Thread.sleep() methodu
    işimize yaramayabilir. Bu gibi durumlarda webdriverwait ile max. belirttiğimiz süre boyunca elementin
    etkileşime girmesini bekletebiliriz.
    Explicit Wait ile birde fluentWait kullanımı vardır. WebDriverWait ile arasındaki fark fluentwaitte
    bekleme aralığını kendimiz belirleriz
EXPLICT WAIT/WebDriverWait --> Bir webelementin sayfa yüklendikten sonra etkileşime girebilmesi için
max. belirtmiş olduğumuz süre kadar default olarak yarım saniyelik araliklar ile bekler. Örneğin bir
webelemente tıkladıktan son çıkan bir webelement yada bir alert'ün çıkması testimizi her çalıştırdığımızda
farklı sürelerde oluşabilir. Dolayısıyla bunu süreyi kestiremediğimizden dolayı Thread.Sleep ile yapmamız
çok mantıklı ve profesyonelce olmaz. Bu gibi durumlarda WebDriverWait ile bir webelementin oluşmasını
bekletmek daha profesyonelce ve daha dinamik olur. Bunun için WebDriverWait class'ından bir obje oluşturup
parametre olarak driver'i ve max. süreyi belirtiriz.

    EXPLICT WAIT/FluentWait --> Bir webelementin sayfa yüklendikten sonra etkileşime girebilmesi için max.
belirtmiş olduğumuz süre kadar bizim belirttiğimiz aralıklarda bekler
 */

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldWE = driver.findElement(By.xpath("(//h4)[2]"));
        /*
        1-Hangi webelementi görünür olana kadar beklemek istiyorsak o webelementin locate'ini alırız
        2-WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); wait objesi oluştururuz
         */
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(helloWorldWE));

        Assert.assertEquals("Hello World!",helloWorldWE.getText());





    }


    @Test
    public void test02() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et

        WebElement helloWorldWE= new WebDriverWait(driver,Duration.ofSeconds(15)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));
      // Locate'nini aldığımız yukarıdaki webelemnti görünür olana kdar bekleyecek

        Assert.assertEquals("Hello World!", helloWorldWE);
    }

    @Test
    public void test03() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));

        Assert.assertEquals("Hello World!",driver.findElement(By.xpath("(//h4)[2]")).getText());
    }
}

