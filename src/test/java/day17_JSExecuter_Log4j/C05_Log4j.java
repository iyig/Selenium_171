package day17_JSExecuter_Log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_Log4j extends TestBase {

    @Test
    public void test01() {

       /*

       Log4j kullanabilmek icin öncelikle lof4j-core ve log4j-api dependencyleri pom.xml dosyasına koyarız
       2.src main resorces altında log4j2.xml isimli dosyayı oluşturup pfd teki yine pdf de belirtilen
       adressten xml kodlarını bu dosyanın içerisine koyar
       3.Info bilgilerini her stepten sonra yazdırabilmek icin Logger arayüzünden bir abje oluşturup
       bunu LogManager classından getLogger methoduna eşitler bu method içne classımızı belirtiriz

        */
        Logger logger = LogManager.getLogger(C05_Log4j.class);
        // amazon sayfasına gidelim
        driver.get("https://amazon.com");
        logger.info("Kullanici Amazon sayfasına gider");
//arama kutusunda java aratalım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        logger.info("Kullnıcı arama kutusunu locate etti");
        aramaKutusu.sendKeys("java", Keys.ENTER);
        logger.info("Kullanıcı arama kutusunda java arattı");

    }
}