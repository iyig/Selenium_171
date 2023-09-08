package day17_JSExecuter_Log4j;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSExecuterScroll extends TestBase {
    @Test
    public void test01() {


        driver.get("https://amazon.com");
        bekle(3);

        //Back To School Webelementine kadar scroll yapalım

        WebElement backToScollWE = driver.findElement(By.xpath("//*[text()='Back to school']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", backToScollWE);
    }

    @Test
    public void test02() {
        //Back To School Webelementine kadar scroll yapalım
        WebElement backToSchoolWE = driver.findElement(By.xpath("//*[text()='Back to school']"));
        jsScroll(backToSchoolWE);// TestBase deki method ile scroll yaptık

    }

    @Test
    public void test03() {

        // technoproeducation git
        driver.get("https://techproeducation.com");

        //sayfanın en altına scroll yapalım
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
       /*
       yukarıdaki method js executer ile sayfanın en altına scroll yapar.Spesifik olarak
       bir webelemente scroll yapmadığımız icin sayfayı scroll yaptıgımız için script kodu window ile başlarscrollTo methodu ile  x ve y kordi
       natı belirtmemiz gerekir. x'e 0 y'ye bir deger verirsek verdigimiz deger kadar aşağıya dogru scroll yapar. Ama sayfanın en altına scroll
       yapmasına istersek y degeri yerine 'document.body.scrollHeight' script kodunu kullanırz.

        */
        bekle(3);

        //Sayfanın en üstüne scroll yapalım
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    @Test
    public void test04() {

        // technoproeducation git
        driver.get("https://techproeducation.com");

        //sayfanın en altına scroll yapalı
        jsScrollEnd();
        bekle(3);

        //sayfanın en üstüne scroll yapalı
        jsScrollHome();
      //Back To School Webelementine kadar scroll yapalım
        WebElement backToSchoolWE = driver.findElement(By.xpath("//*[text()='Back to school']"));
        jsScroll(backToSchoolWE);// TestBase deki method ile scroll yaptık
    }
}