package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethodsTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        // 1.Techpro sayfasina gidelim. https://www.techproeducation.com/

        driver.get( "https://www.techproeducation.com");

        //2.Sayfa basligini(title) yazdirin

        System.out.println(driver.getTitle());

        //3.Sayfa basliginin “Amazon” icerdigini test edin
        if(driver.getTitle().contains("Techpro")){
            System.out.println("Test Passed");

        }else System.out.println("Test failed");


        //4.Sayfa adresini(url) yazdirin
        System.out.println("Sayfa Url'i" + driver.getCurrentUrl());

        //  5.Sayfa url’inin “techpro” icerdigini test edin.
        if(driver.getCurrentUrl().contains("techpro")){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAİLED");

        // 6.Sayfa handle degerini yazdirin
        System.out.println("Sayfa Handle Degeri" +driver.getWindowHandle());
/*
            getWindowHandle() methodu ile kendimiz isteyerek başka bir pencereye geçiş yaptığımızda iki tane pencere
        açmış olucaz. Dolayısıyla ilk açtığımız pencereye tekrar geçiş yapmak istediğimizde ilk açtığımız pencereden
        sonra almış olduğumuz window handle değeri ile geçiş yapabiliriz. Pencereler arası geçiş konusunda bunu detaylı
        göreceğiz. Birde bir sayfaya gittiğimizde bir linke tıkladığımızda bizim kontrolümüz dışında yeni bir pencere
        açılabilir. Bu gibi durumlarda da getWindowHandles() methodu ile driver'in açmış olduğu pencerelerin handle
        değerlerini bir list'e assing ederiz ve istediğimiz pencereye index ile çok rahat geçiş yapabiliriz.
         */

        //    7.Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin

        System.out.println(driver.getPageSource());
        System.out.println(driver.getPageSource().contains("Gateway"));
        // 8.Sayfayi kapatin.
        driver.close(); // close() methodu driverin en son açtığı sayfayı kapatır
        //driver.quit(); bu method ise bizim açtığımız birden fazla sekme yada pencerelerin hepsinin kapatmak icin kullanır

    }

}
