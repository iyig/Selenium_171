package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ManageMethods {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        /*

        Driver'i oluşturduktan sonra maximize yapmamız bizim icin gitme istediğimiz sayfadaki elementlere daha rahat
        sorunsuz ulaşmamız için önemlidir
        bunun için driver'i hemen oluşturduktan sonra manage().window.maximize() methodu kullanırız
        Maximize yaptıktan sonra internetten kaynak sayfa performansından kaynaklı sayfadaki elemnentler hemen yüklenemeyebilir
        Dolaysıyla sayfaya gittikten sonra bir elemente bir butona tıklamak istediginizde hemen sayfa yüklenmez ise elementi
        bulamayacağı icin tıklama işlemini gerçekleştiremeyecegi icin testimiz fail vericektir.Bunun önüne geçmek için
        maximize methodundan sonra drivr'ımıza seleniumdan gelen implicitly waitataması yaparız. Bu wait ile sayfanın tüm elementlerinin
        oluşmasını beklemesi icin max. bir süre belirtiriz
         */

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //techpro sayfasina gidiniz
        driver.get("https://techproeducation.com");

        //sayfa baslığının TechPro içerdiğini test ediniz
        if (driver.getTitle().contains("TechPro")){
            System.out.println("PASSED");
        }else System.out.println("FAILED");

        // sayfa başlıgının TechPro içerdigini test ediniz

        driver.close();
    }




}
