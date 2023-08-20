package day07_Dropdown_Alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropdownMenu {
    WebDriver driver;

    /*
Dropdown menü; alt başlıkların listelendiği sayfadaki bir webelemente denir
Drowdown webelementine sendkeys() methodu ile  listede bulunan seçeneklerden istedimizi gönderebilirz
Gönderemediğimiz durumlarda select classındn bir obje oluşturarak bu olusturduğumuz objeye parametre
olarak locate ettipimiz dropdown webelementini yazarız.Bu oluşturduğumuz obje ile byIndex, byvisibletext ve byValue
methodları ile drowdown secenekleriden istedigimizi secebiliriz. getOptions() methodu ile tüm dropdown menüdeki seçenekleri
listeleyebiliriz.getFirstSelectedOption() methodu ile dropdown menüde ilk seçili olan seceneğı getirir.
 Bir Dropdown menu<select> tagına sahip degilse Select classını kullanamazsınız
Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
-3 farklı test methodu oluşturalım
    1.Method:
        a. Yil,ay,gün dropdown menu'leri locate ediniz
        b. Select objesi olustur
        c. Select object i kullaarak 3 farkli sekilde secim yapiniz
    2.Method:
        a. Tüm eyalet isimlerini yazdıralım
    3.Method:
        a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

 */

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
// a. Yil,ay,gün dropdown menu'leri locate ediniz
    @Test
    public void test1() {

        WebElement yıl=driver.findElement(By.xpath("//*[@id='year']"));
        WebElement ay= driver.findElement(By.cssSelector("select#month"));
        WebElement gun=driver.findElement(By.cssSelector("select#day"));
        
        // b. Select objesi olustur
        
        //b. Select objesi olustur
        Select selectyil = new Select(yıl);
        Select selectay = new Select(ay);
        Select selectgun = new Select(gun);

//c. Select object i kullanarak 3 farkli sekilde secim yapiniz
        selectyil.selectByIndex(5);
        selectay.selectByVisibleText("May");
        selectgun.selectByValue("22");
        
        
    }

    @Test
    public void test2() {
        //a. Tüm eyalet isimlerini yazdıralım
        WebElement eyaletler = driver.findElement(By.cssSelector("select#state"));
        Select select = new Select(eyaletler);
        List<WebElement> eyaletListesi = select.getOptions();
        eyaletListesi.forEach(t-> System.out.println(t.getText()));
    }

    @Test
    public void test3() {
    //a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement state = driver.findElement(By.cssSelector("select#state"));

        Select select = new Select(state);
       String seciliOlanSecenek= select.getFirstSelectedOption().getText();
        //System.out.println(select.getFirstSelectedOption().getText());
        System.out.println(seciliOlanSecenek);
        Assert.assertEquals("Select a State",select.getFirstSelectedOption().getText());
    }

    @Test
    public void test4() {
List<WebElement>eyaletlerListesi=driver.findElements(By.xpath("//select[@id='state']//option"));
eyaletlerListesi.forEach(t-> System.out.println(t.getText()));

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }
}




