package day04_GetTagNameGetAtrribute_Xpath_Css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_GetTagNameGetAttribute {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //techproeducation sayfasına gidelim

        driver.get("https://techproeducation.com");
//<input id="searchHeaderInput" type="text" class="form-input" placeholder="Search Program">
        // Arama kutusunu locate edelim
        WebElement aramaKutusu=driver.findElement(By.id("searchHeaderInput"));

        // arama kutusunun tag name'inin input oldugunu test edelim
        System.out.println("Arama kutusu WebElementi Tag Name'i:" + aramaKutusu.getTagName());
        String gercekTagName= aramaKutusu.getTagName();
        String istenenTagName="input";
        if(gercekTagName.equals(istenenTagName)){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAİLED");




        // arama kutusunun class attributunun degerinin form_input olduğunu test edeiniz
        String gercekAttributeName=aramaKutusu.getAttribute("class");  //-->form-input
        System.out.println(gercekAttributeName);

        String beklenenAttributeDegeri="form-input";
        if (gercekAttributeName.equals(beklenenAttributeDegeri)){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAİLED");

    }


}
