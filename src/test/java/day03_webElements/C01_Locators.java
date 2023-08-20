package day03_webElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Locators {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // Amazon sayfasına gidiniz
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

        //Arama kutusunu locate ediniz ve iphone arartırınız
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone");
        aramaKutusu.submit();
// Eger bir locate'i tek bir kere kullanacaksak
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);


/*
<input type="text" id="twotabsearchtextbox" value="" name="field-keywords"
autocomplete="off" placeholder="Search Amazon" class="nav-input nav-progressive-attribute"
dir="auto" tabindex="0" aria-label="Search Amazon" spellcheck="false">
 */


        /*
    Sayfadaki bir webelementi locate etmek için öncelikle locate edeceğimin webelementin
üzerine sağ tıklayıp sayfanın altında açılan weblementle alakalı html kodlarına ulaşabiliriz.
Bu html kodları yardımıyla eğer webelementin html kodlarında id attribute'üne sahip bir değer
varsa locate için önce bunu kullanabiliriz. Attribüt değerine çift tıklayıp ctrl+c --> ctrl+f -->ctrl+v
yaparak öğenin unique(tek) olup olmadığını html kodların alt kısmındaki arama bölümünden kontrol ederiz.
Ve tek olan attribüte değerini o webelmenti handle edebilmek için çok rahat yukarıdaki örnekteki gibi
kullanabiliriz.
    Input tag'ına sahip bir webelementi locate ettikten sonra sendKeys() methodu ile
o webelemente istediğimiz text'i gönderebiliriz.
Bir text'i arama kutusuna gönderdikten sonra klavyeden nasıl enter tuşuna basıyorsak otomasyon ilede
bunu yaptırabiliriz. Bunun için iki yol vardır.
                        1.si submit() methodunu kullanarak enter yaptırabiliriz.
                        2.si tanımlanmış veri tipi olan(enum) Keys.ENTER' ı kullanabiliriz.
 */
    }

}
